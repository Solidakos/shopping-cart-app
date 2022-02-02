package com.shoppingcartapp.exceptions;

public class DVDNotFoundException extends RuntimeException{

    public DVDNotFoundException(Integer id) {
        super("Could not find DVD " + id);
      }
    
}
