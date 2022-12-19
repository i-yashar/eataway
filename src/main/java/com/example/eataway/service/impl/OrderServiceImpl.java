package com.example.eataway.service.impl;

import com.example.eataway.dto.OrderTrackingInfo;
import com.example.eataway.model.entity.Menu;
import com.example.eataway.model.entity.Order;
import com.example.eataway.repository.MenuRepository;
import com.example.eataway.service.OrderService;

import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private final MenuRepository menuRepository;
    private Order currentOrder;

    public OrderServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Order addMenu(Long menuId) {
        Optional<Menu> optMenu = this.menuRepository.findById(menuId);

        if(optMenu.isEmpty()) {
            throw new IllegalArgumentException("Menu with id: " + menuId + " not found");
        }

        Order order = createOrder();
        order.getMenus().add(optMenu.get());

        return order;
    }

    private Order createOrder() {
        if(currentOrder == null) {
            currentOrder = new Order();
        }

        return currentOrder;
    }

    @Override
    public OrderTrackingInfo placeOrder(Long userId) {
        return null;
    }

    @Override
    public OrderTrackingInfo cancelOrder(Long userId) {
        return null;
    }
}
