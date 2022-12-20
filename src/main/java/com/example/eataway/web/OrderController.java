package com.example.eataway.web;

import com.example.eataway.dto.OrderTrackingInfo;
import com.example.eataway.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("eataway/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("cart")
    public String getOrdersCart(Model model, Principal principal) {
        model.addAttribute("orderInfo", orderService.getOrderInfo(principal.getName()));
        model.addAttribute("menus", orderService.getOrderMenus(principal.getName()));
        return "cart";
    }

    @GetMapping("place")
    public String finishOrder(Principal principal, RedirectAttributes redirectAttributes) {
        OrderTrackingInfo orderTrackingInfo = orderService.placeOrder(principal.getName());
        redirectAttributes.addFlashAttribute("orderTrackingInfo", orderTrackingInfo);
        return "redirect:/eataway/orders/tracking/" + orderTrackingInfo.getOrderId();
    }

    @GetMapping("tracking/{orderId}")
    public String getOrderTrackingInfo(@PathVariable Long orderId,
                                       @ModelAttribute OrderTrackingInfo orderTrackingInfo,
                                       Model model) {
        model.addAttribute("orderTrackingInfo", orderTrackingInfo);
        return "tracking";
    }
}
