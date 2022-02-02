package com.shoppingcartapp.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Integer id) {
        super("Could not find Order with ID:" + id);
    }

}
