package com.bdqn.entity;

import java.util.Map;

public class ShoppingCat {
    //存储购物信息
    Map<String, ShoppingInfo> shoppings;

    //存储所有购物信息的总价格
    private double sumPrice;

    //订单编号
    private String orderId;

    public ShoppingCat(Map<String, ShoppingInfo> shoppings, double sumPrice) {
        this.shoppings = shoppings;
        this.sumPrice = sumPrice;
    }

    public ShoppingCat(){};

    public Map<String, ShoppingInfo> getShoppings() {
        return shoppings;
    }

    public void setShoppings(Map<String, ShoppingInfo> shoppings) {
        this.shoppings = shoppings;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    //计算所有购物的总价格
    public void sum(){
        double sumPrice = 0.0;
        for(ShoppingInfo value : shoppings.values()){
            sumPrice+=value.getPrice();
        }
        this.setSumPrice(sumPrice);
    }
}
