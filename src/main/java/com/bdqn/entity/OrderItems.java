package com.bdqn.entity;

public class OrderItems {
    private Integer quantity;
    private double total;
    private String pid;
    private String oid;

    public OrderItems(Integer quantity, double total, String pid, String oid) {
        this.quantity = quantity;
        this.total = total;
        this.pid = pid;
        this.oid = oid;
    }

    public OrderItems(){}



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
