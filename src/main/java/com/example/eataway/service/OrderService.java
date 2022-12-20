package com.example.eataway.service;

import com.example.eataway.dto.OrderInfoDTO;
import com.example.eataway.dto.OrderTrackingInfo;
import com.example.eataway.model.entity.Menu;
import com.example.eataway.model.entity.Order;

import java.util.List;

public interface OrderService {
    Order addMenu(Long menuId, String user);
    OrderInfoDTO getOrderInfo(String email);
    List<Menu> getOrderMenus(String email);
    OrderTrackingInfo placeOrder(String email);
    OrderTrackingInfo cancelOrder(Long userId);
}
