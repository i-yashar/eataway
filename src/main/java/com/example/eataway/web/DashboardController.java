package com.example.eataway.web;

import com.example.eataway.service.MenuService;
import com.example.eataway.service.OrderService;
import com.example.eataway.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/eataway")
public class DashboardController {

    private final RestaurantService restaurantService;
    private final MenuService menuService;
    private final OrderService orderService;

    public DashboardController(RestaurantService restaurantService, MenuService menuService, OrderService orderService) {
        this.restaurantService = restaurantService;
        this.menuService = menuService;
        this.orderService = orderService;
    }

    @GetMapping
    public String welcomePage(Model model, Principal principal) {
        if(principal != null) {
            model.addAttribute("user", principal.getName());
        }
        return "welcome";
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

    @GetMapping("restaurants/{restaurantId}/menus/{menuId}/addToCart")
    public String addMenuToCart(@PathVariable Long restaurantId, @PathVariable Long menuId, Principal principal) {
        orderService.addMenu(menuId, principal.getName());
        return "redirect:/eataway/restaurants";
    }
}
