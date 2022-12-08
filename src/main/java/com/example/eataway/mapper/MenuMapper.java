package com.example.eataway.mapper;

import com.example.eataway.dto.MenuExportDTO;
import com.example.eataway.model.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MenuMapper {
    public MenuExportDTO toDTO(Menu menu) {
        return new MenuExportDTO()
                .setId(menu.getId())
                .setName(menu.getName())
                .setDescription(menu.getDescription())
                .setPrice(menu.getPrice())
                .setItems(menu.getItems().stream()
                        .map(item -> {
                            return item.getName() + " - " + item.getQuantity() + "grams";
                        })
                        .collect(Collectors.toList()));
    }
}
