package com.shoppingcartapp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.shoppingcartapp.entities.DVD;
import com.shoppingcartapp.repositories.DVDRepository;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class DVDController {
    private final DVDRepository repo;

    private final DVDModelAssembler assembler;

    DVDController(DVDRepository repo, DVDModelAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }

    @GetMapping("/dvds")
    public CollectionModel<EntityModel<DVD>> all() {
        List<EntityModel<DVD>> dvds = repo.findAll()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(dvds, linkTo(methodOn(DVDController.class).all()).withSelfRel());
    }

    @GetMapping("/dvds/{id}")
    EntityModel<DVD> one(@PathVariable Integer id) {
        DVD dvd = repo.findById(id).orElseThrow(() -> new DVDNotFoundException(id));

        return assembler.toModel(dvd);
    }
}
