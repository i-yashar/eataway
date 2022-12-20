package com.example.eataway.repository;

import com.example.eataway.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByUser_EmailAndStatus(String email, String status);
}
