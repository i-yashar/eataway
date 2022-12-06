package com.example.eataway.service;

import com.example.eataway.model.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getRestaurants();

    Restaurant getRestaurantById(Long id);
}
