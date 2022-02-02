package com.shoppingcartapp.controllers;

import com.shoppingcartapp.entities.Order;
import com.shoppingcartapp.entities.Status;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order) {
        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        if (order.getStatus() == Status.CREATED) {
            orderModel.add(linkTo(methodOn(OrderController.class).charge(order.getId())).withRel("charge"));
            orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
        } else if (order.getStatus() == Status.CHARGED) {
            orderModel.add(linkTo(methodOn(OrderController.class).inprogress(order.getId())).withRel("in-progress"));
        } else if (order.getStatus() == Status.IN_PROGRESS) {
            orderModel.add(linkTo(methodOn(OrderController.class).complete(order.getId())).withRel("complete"));
        }
        return orderModel;
    }

}
