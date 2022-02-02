package com.shoppingcartapp.entities;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformers;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order {

    private @Id @GeneratedValue int id;
    private String address;
    private Status status;

    @OneToOne
    private ShoppingCard sCard;

    public Order() {
    }

    public Order(String address, Status status) {
        this.address = address;
        this.status = status;
    }

    public Order(String address, Status status, ShoppingCard sCard) {
        this.address = address;
        this.status = status;
        this.sCard = sCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ShoppingCard getsCard() {
        return sCard;
    }

    public void setsCard(ShoppingCard sCard) {
        this.sCard = sCard;
    }

}