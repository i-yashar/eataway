package com.example.eataway.web;

import com.example.eataway.service.MenuService;
import com.example.eataway.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eataway")
public class DashboardController {

    private final RestaurantService restaurantService;
    private final MenuService menuService;

    public DashboardController(RestaurantService restaurantService, MenuService menuService) {
        this.restaurantService = restaurantService;
        this.menuService = menuService;
    }

    @GetMapping("restaurants")
    public String getRestaurants(Model model) {
        model.addAttribute("restaurants", this.restaurantService.getRestaurants());
        return "restaurants";
    }

    @GetMapping("restaurants/{id}")
    public String getRestaurantMenus(@PathVariable Long id, Model model) {
        model.addAttribute("restaurant", this.restaurantService.getRestaurantById(id));
        model.addAttribute("menus", this.menuService.getMenusByRestaurant(id));

        return "restaurant-menus";
    }
}
