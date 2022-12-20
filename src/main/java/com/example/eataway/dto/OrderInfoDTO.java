package com.example.eataway.dto;

public class OrderInfoDTO {
    private String address;
    private Double total;

    public String getAddress() {
        return address;
    }

    public OrderInfoDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public OrderInfoDTO setTotal(Double total) {
        this.total = total;
        return this;
    }
}
