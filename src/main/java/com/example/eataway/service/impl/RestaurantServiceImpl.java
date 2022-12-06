package com.example.eataway.service.impl;

import com.example.eataway.model.entity.Restaurant;
import com.example.eataway.repository.RestaurantRepository;
import com.example.eataway.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return this.restaurantRepository.findById(id).orElseThrow();
    }
}
