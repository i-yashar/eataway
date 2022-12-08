package com.example.eataway.service;

import com.example.eataway.dto.MenuExportDTO;
import com.example.eataway.model.entity.Menu;

import java.util.Collection;
import java.util.List;

public interface MenuService {
    List<MenuExportDTO> getMenusByRestaurant(Long restaurantId);
}
