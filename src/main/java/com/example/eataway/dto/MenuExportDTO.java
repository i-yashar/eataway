package com.example.eataway.dto;

import java.util.List;

public class MenuExportDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private List<String> items;

    public Long getId() {
        return id;
    }

    public MenuExportDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MenuExportDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuExportDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public MenuExportDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public List<String> getItems() {
        return items;
    }

    public MenuExportDTO setItems(List<String> items) {
        this.items = items;
        return this;
    }
}
