package com.shoppingcartapp.repositories;

import com.shoppingcartapp.entities.DVD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDRepository extends JpaRepository<DVD, Integer> {

}
