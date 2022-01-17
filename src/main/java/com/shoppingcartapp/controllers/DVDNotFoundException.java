package com.shoppingcartapp.controllers;

public class DVDNotFoundException extends RuntimeException{

    DVDNotFoundException(Integer id) {
        super("Could not find DVD " + id);
      }
    
}
