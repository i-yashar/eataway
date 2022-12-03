package com.example.eataway.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String deliveryAddress;

    @ManyToMany
    private Set<Menu> menus;

    @ManyToOne
    private Student student;

    @ManyToOne
    private User user;
}
