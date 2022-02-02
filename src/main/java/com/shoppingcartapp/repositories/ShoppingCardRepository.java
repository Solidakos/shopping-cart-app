package com.shoppingcartapp.repositories;

import com.shoppingcartapp.entities.ShoppingCard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRepository extends JpaRepository<ShoppingCard, Integer> {
    
}
