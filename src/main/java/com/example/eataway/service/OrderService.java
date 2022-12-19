package com.example.eataway.service;

import com.example.eataway.dto.OrderTrackingInfo;
import com.example.eataway.model.entity.Menu;
import com.example.eataway.model.entity.Order;

public interface OrderService {
    Order addMenu(Long menuId);
    OrderTrackingInfo placeOrder(Long userId);
    OrderTrackingInfo cancelOrder(Long userId);
}
