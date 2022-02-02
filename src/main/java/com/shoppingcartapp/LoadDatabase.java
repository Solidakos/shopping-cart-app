package com.shoppingcartapp;

import com.shoppingcartapp.entities.CardStatus;
import com.shoppingcartapp.entities.DVD;
import com.shoppingcartapp.entities.Order;
import com.shoppingcartapp.entities.ShoppingCard;
import com.shoppingcartapp.entities.Status;
import com.shoppingcartapp.repositories.DVDRepository;
import com.shoppingcartapp.repositories.OrderRepository;
import com.shoppingcartapp.repositories.ShoppingCardRepository;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    String[] actors1 = new String[] { "Timothee Chalamet", "Rebecca Ferguson", "Oscar Isaac" };
    String[] actors2 = new String[] { "Dev Patel", "Alicia Vikander", "Joel Edgerton" };
    ShoppingCard sCard = new ShoppingCard(CardStatus.FROZEN, 100);

    @Bean
    CommandLineRunner initDatabase(DVDRepository dvdRepository, OrderRepository orderRepository, ShoppingCardRepository shoppingCardRepository) {
        return args -> {
            log.info("Preloading "
                    + dvdRepository.save(new DVD("Dune", actors1, "Denis Villeneuve", "Sci-Fi", 155, 30)));
            log.info("Preloading " + dvdRepository
                    .save(new DVD("The Green Knight", actors2, "David Lowery", "Medieval Fantasy", 130, 20)));
            log.info("Preloading" + shoppingCardRepository.save(sCard));
            log.info("Preloading " + orderRepository.save(new Order("Test Created", Status.CREATED, sCard)));
            log.info("Preloading " + orderRepository.save(new Order("Test Charged", Status.CHARGED)));
        };
    }

}
