package com.example.eataway.service.impl;

import com.example.eataway.model.entity.Menu;
import com.example.eataway.repository.MenuRepository;
import com.example.eataway.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Collection<Menu> getMenusByRestaurant(Long restaurantId) {
        return this.menuRepository.findAllByRestaurantId(restaurantId);
    }
}
