package com.bdqn.service;

import com.bdqn.dao.ODao;
import com.bdqn.entity.Order;
import com.bdqn.entity.OrderItems;
import com.bdqn.entity.ShoppingCat;
import com.bdqn.entity.ShoppingInfo;
import com.bdqn.exception.OrderException;
import com.bdqn.exception.OrderItemsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ServiceOrderImpl implements ServiceOrder{

    //自动注入Dao层商品对象
    @Resource
    ODao oDao;

    /**
     * rollbackFor： 表示发生指定的异常一定回滚
     *   处理逻辑：
     *       1）spring框架会首先检查方法抛出的异常是不是在rollbackFor的属性值中
     *           如果异常在rollbackFor列表中，不管是什么类型的异常，一定会回滚
     *
     *        2)如果抛出的异常不在rollbackFor列表中，spring会判断异常是不是RuntimeException，
     *           如果是一定回滚。
     * */
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {NullPointerException.class, OrderException.class, OrderItemsException.class}
    )

    @Override
    public String addOrder(String address, String username, String phone,String uid, ShoppingCat shoppingCat) {

        //获取订单编号
        String oId = shoppingCat.getOrderId();
        //获取总金额
        double sum = shoppingCat.getSumPrice();
        //获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间

        //声明实体类对象，将数据填充进去
        Order order = new Order(oId,date,sum,1,address,username,phone,uid);
        //调用dao
        int count = oDao.addOrder(order);
        if(count<=0){
            throw new OrderException("订单添加失败");
        }

        for(ShoppingInfo item : shoppingCat.getShoppings().values()){
            //实例化订单项
            OrderItems items = new OrderItems(item.getNum(),item.getPrice(),item.getProduct().getPid(),oId);
            //调用dao
            int count2 = oDao.addOrderItems(items);
            if(count2<=0){
                throw new OrderItemsException("订单项添加失败");
            }
        }
        return "订单成功";
    }
}
