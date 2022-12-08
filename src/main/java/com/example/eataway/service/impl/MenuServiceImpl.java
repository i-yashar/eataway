package com.example.eataway.service.impl;

import com.example.eataway.dto.MenuExportDTO;
import com.example.eataway.mapper.MenuMapper;
import com.example.eataway.model.entity.Menu;
import com.example.eataway.repository.MenuRepository;
import com.example.eataway.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper mapper;

    public MenuServiceImpl(MenuRepository menuRepository, MenuMapper mapper) {
        this.menuRepository = menuRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MenuExportDTO> getMenusByRestaurant(Long restaurantId) {
        return this.menuRepository.findAllByRestaurantId(restaurantId)
                .stream()
                .map(this.mapper::toDTO)
                .collect(Collectors.toList());
    }
}
