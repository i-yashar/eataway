package com.example.eataway.service.impl;

import com.example.eataway.dto.OrderInfoDTO;
import com.example.eataway.dto.OrderTrackingInfo;
import com.example.eataway.model.entity.Menu;
import com.example.eataway.model.entity.Order;
import com.example.eataway.repository.MenuRepository;
import com.example.eataway.repository.OrderRepository;
import com.example.eataway.repository.UserRepository;
import com.example.eataway.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private Order currentOrder;

    public OrderServiceImpl(MenuRepository menuRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order addMenu(Long menuId, String email) {
        Optional<Menu> optMenu = this.menuRepository.findById(menuId);

        if (optMenu.isEmpty()) {
            throw new IllegalArgumentException("Menu with id: " + menuId + " not found");
        }

        Order order = getOrder(email);

        order.getMenus().add(optMenu.get());

        return orderRepository.save(order);
    }

    @Override
    public OrderInfoDTO getOrderInfo(String email) {
        Order order = getOrder(email);
        return new OrderInfoDTO()
                .setAddress("Ocean Street 63")
                .setTotal(order.getMenus().stream().map(Menu::getPrice).reduce(0.0, Double::sum));
    }

    @Override
    public List<Menu> getOrderMenus(String email) {
        return new ArrayList<>(getOrder(email).getMenus());
    }


    @Override
    public OrderTrackingInfo placeOrder(String email) {
        Order order = getOrder(email);
        order.setStatus("placed");

        orderRepository.save(order);

        return new OrderTrackingInfo()
                .setOrderId(order.getId())
                .setStatus("In progress")
                .setUserId(userRepository.findByEmail(email).get().getId())
                .setDeliveryDriverId(null);
    }

    @Override
    public OrderTrackingInfo cancelOrder(Long userId) {
        return null;
    }

    private Order getOrder(String email) {
        return orderRepository
                .findByUser_EmailAndStatus(email, "new")
                .orElseGet(() -> {
                    Order order = new Order().setDeliveryAddress("").setMenus(new HashSet<>()).setStatus("new").setDeliveryDriver(null).setUser(userRepository.findByEmail(email).get());
                    return orderRepository.save(order);
                });
    }
}
