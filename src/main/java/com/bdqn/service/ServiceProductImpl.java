package com.bdqn.service;

import com.bdqn.dao.PDao;
import com.bdqn.entity.Product;
import com.bdqn.entity.ShoppingCat;
import com.bdqn.entity.ShoppingInfo;
import com.bdqn.util.MyRandom;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceProductImpl implements ServiceProduct{

    //自动注入Dao层商品对象
    @Resource
    PDao pDao;

    //声明list集合存储存放商品信息的对象
    Map<String, ShoppingInfo> shopInfoList = new HashMap<>();
    //声明ShoppingCat类，该类相当于购物车，购物车里存放着购物信息
    ShoppingCat cat = new ShoppingCat();

    //查询热门商品信息
    public List<Product> hots(){
        //调用方法
        return pDao.hots();
    };

    //查询最新商品信息
    public List<Product> nets(){
        return pDao.nets();
    };

    //查询指定商品
    public Product pInfo(int pid){
        return pDao.pInfo(pid);
    }

    //分页查询商品
    public List<Product> pageInfo(int num){
        PageHelper.startPage(num,12);
        return pDao.pageInfo();
    }

    //查询指定商品及该商品的数量
    public ShoppingCat pInfoList(Integer pid, Integer num){
        //声明存储商品信息的对象
        ShoppingInfo shopInfo = new ShoppingInfo();

        //查询数据
        Product product = pDao.pInfo(pid);
        //将查询到的数据信息进行修改，比如：根据商品的数量来修改商品价格
        shopInfo.setPrice(product.getShop_price()*num);
        shopInfo.setNum(num);
        shopInfo.setProduct(product);
        //将商品信息及商品编号添加到map集合中
        shopInfoList.put(product.getPid(),shopInfo);
        //将map集合添加到cat对象中，并存储集合中所有商品的总价格
        cat.setShoppings(shopInfoList);
        //计算集合中所有购物的总价格
        cat.sum();
        return cat;
    }

    //删除指定商品
    public ShoppingCat delte(String pid){
        //在map中(用户的购物车中)删除指定key的数据(商品)
        cat.getShoppings().remove(pid);
        //删除完后刷新总价格
        cat.sum();
        //返回改完后的数据
        return cat;
    }

    ////将购物车里的数据显示到订单页面中
    public ShoppingCat orderInfoView(){
        //生成四位随机数
        cat.setOrderId(MyRandom.OID());
        return cat;
    }

}
