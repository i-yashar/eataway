package com.example.eataway.model.entity;

import org.hibernate.annotations.Fetch;

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Menu> menus;

    @ManyToOne
    private DeliveryDriver deliveryDriver;

    @ManyToOne
    private User user;

    private String status;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Order setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public Order setMenus(Set<Menu> menus) {
        this.menus = menus;
        return this;
    }

    public DeliveryDriver getDeliveryDriver() {
        return deliveryDriver;
    }

    public Order setDeliveryDriver(DeliveryDriver deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }
}
