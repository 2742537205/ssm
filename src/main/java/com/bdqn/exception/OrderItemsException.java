package com.bdqn.exception;

public class OrderItemsException extends RuntimeException{
    public OrderItemsException() {
    }

    public OrderItemsException(String message) {
        super(message);
    }
}
