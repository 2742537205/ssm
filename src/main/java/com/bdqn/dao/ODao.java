package com.bdqn.dao;

import com.bdqn.entity.Order;
import com.bdqn.entity.OrderItems;

public interface ODao {
    //添加订单总信息
    int addOrder(Order order);

    //添加订单项信息
    int addOrderItems(OrderItems orderItems);
}
