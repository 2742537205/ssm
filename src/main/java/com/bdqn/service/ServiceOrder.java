package com.bdqn.service;

import com.bdqn.entity.ShoppingCat;

public interface ServiceOrder {
    //将购物车中的信息添加到数据库中
    String addOrder(String address, String username, String phone,String uid, ShoppingCat shoppingCat);
}
