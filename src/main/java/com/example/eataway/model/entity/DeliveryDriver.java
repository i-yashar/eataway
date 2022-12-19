package com.example.eataway.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "delivery_drivers")
public class DeliveryDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double rating;
}
