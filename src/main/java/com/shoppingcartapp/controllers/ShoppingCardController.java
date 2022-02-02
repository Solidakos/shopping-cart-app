package com.shoppingcartapp.controllers;

import com.shoppingcartapp.repositories.ShoppingCardRepository;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCardController {
    private final ShoppingCardRepository sRepository;

    public ShoppingCardController(ShoppingCardRepository sRepository){
        this.sRepository = sRepository;
    }

    
    
}
