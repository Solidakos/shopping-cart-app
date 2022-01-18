package com.shoppingcartapp.controllers;

import com.shoppingcartapp.entities.DVD;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class DVDModelAssembler implements RepresentationModelAssembler<DVD,EntityModel<DVD>>{
    
    @Override
    public EntityModel<DVD> toModel(DVD dvd){
        return EntityModel.of(dvd,
            linkTo(methodOn(DVDController.class).one(dvd.getId())).withSelfRel(),
            linkTo(methodOn(DVDController.class).all()).withRel("dvds"));
    }
    
}
