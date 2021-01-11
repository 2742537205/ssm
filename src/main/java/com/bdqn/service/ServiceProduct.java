package com.bdqn.service;

import com.bdqn.entity.Product;
import com.bdqn.entity.ShoppingCat;
import com.bdqn.entity.ShoppingInfo;

import java.util.List;
import java.util.Map;

public interface ServiceProduct {
    //查询热门商品信息
    List<Product> hots();

    //查询最新商品信息
    List<Product> nets();
    //查询指定商品
    public Product pInfo(int pid);
    //分页查询商品
    public List<Product> pageInfo(int num);
    //查询指定商品信息及该商品的数量
    public ShoppingCat pInfoList(Integer pid, Integer num);
    //删除指定数据
    public ShoppingCat delte(String pid);
    //给订单页显示数据
    public ShoppingCat orderInfoView();

}
