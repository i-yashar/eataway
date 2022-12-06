package com.example.eataway.service;

import com.example.eataway.model.entity.Menu;

import java.util.Collection;

public interface MenuService {
    Collection<Menu> getMenusByRestaurant(Long restaurantId);
}
