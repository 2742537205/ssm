package com.bdqn.entity;

public class ShoppingInfo {
    //商品数量
    private Integer num;

    //商品信息
    private Product product;

    //商品的总价格
    private double price;


    public ShoppingInfo(Integer num, Product product, double price) {
        this.num = num;
        this.product = product;
        this.price = price;
    }

    public ShoppingInfo(){};

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
