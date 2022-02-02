package com.shoppingcartapp.repositories;

import com.shoppingcartapp.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
