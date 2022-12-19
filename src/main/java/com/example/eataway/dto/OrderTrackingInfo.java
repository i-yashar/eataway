package com.example.eataway.dto;

public class OrderTrackingInfo {
    private Long orderId;
    private Long userId;
    private Long deliveryDriverId;
    private String status;

    public Long getOrderId() {
        return orderId;
    }

    public OrderTrackingInfo setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public OrderTrackingInfo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getDeliveryDriverId() {
        return deliveryDriverId;
    }

    public OrderTrackingInfo setDeliveryDriverId(Long deliveryDriverId) {
        this.deliveryDriverId = deliveryDriverId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrderTrackingInfo setStatus(String status) {
        this.status = status;
        return this;
    }
}
