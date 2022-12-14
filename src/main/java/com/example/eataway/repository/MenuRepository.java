package com.example.eataway.repository;

import com.example.eataway.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Collection<Menu> findAllByRestaurantId(Long restaurantId);
}
