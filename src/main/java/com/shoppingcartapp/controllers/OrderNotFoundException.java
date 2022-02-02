package com.shoppingcartapp.controllers;

public class OrderNotFoundException extends RuntimeException {
    OrderNotFoundException(Integer id) {
        super("Could not find Order with ID:" + id);
    }

}
