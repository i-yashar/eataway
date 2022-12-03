package com.example.eataway.web;

import com.example.eataway.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eataway")
public class DashboardController {

    private final RestaurantService restaurantService;

    public DashboardController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("restaurants")
    public String getRestaurants(Model model) {
        model.addAttribute("restaurants", this.restaurantService.getRestaurants());
        return "restaurants";
    }
}
