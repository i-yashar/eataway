package com.example.eataway.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Double price;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Item> items;

    @ManyToOne
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public Menu setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Menu setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Menu setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Item> getItems() {
        return items;
    }

    public Menu setItems(Set<Item> items) {
        this.items = items;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Menu setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
