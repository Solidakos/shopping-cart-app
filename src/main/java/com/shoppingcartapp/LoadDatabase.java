package com.shoppingcartapp;

import com.shoppingcartapp.entities.DVD;
import com.shoppingcartapp.entities.Order;
import com.shoppingcartapp.entities.Status;
import com.shoppingcartapp.repositories.DVDRepository;
import com.shoppingcartapp.repositories.OrderRepository;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    String[] actors1 = new String[] { "Timothee Chalamet", "Rebecca Ferguson", "Oscar Isaac" };
    String[] actors2 = new String[] { "Dev Patel", "Alicia Vikander", "Joel Edgerton" };

    @Bean
    CommandLineRunner initDatabase(DVDRepository dvdRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading "
                    + dvdRepository.save(new DVD("Dune", actors1, "Denis Villeneuve", "Sci-Fi", 155, 30)));
            log.info("Preloading " + dvdRepository
                    .save(new DVD("The Green Knight", actors2, "David Lowery", "Medieval Fantasy", 130, 20)));
            log.info("Preloading " + orderRepository.save(new Order("Test 123", Status.CREATED)));
        };
    }

}
