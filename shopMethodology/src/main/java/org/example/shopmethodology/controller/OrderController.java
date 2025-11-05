package org.example.shopmethodology.controller;
import lombok.AllArgsConstructor;
import org.example.shopmethodology.aspect.HasAuthorities;
import org.example.shopmethodology.aspect.SecurityAuthorities;
import org.example.shopmethodology.exception.ResourceNotFoundException;
import org.example.shopmethodology.model.Order;
import org.example.shopmethodology.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // GET
    @HasAuthorities(authorities = SecurityAuthorities.ADMIN)
    @GetMapping(path = "{id}")
    public Order getOrderById(@PathVariable Long id) {
        try {
            return orderService.getOrderById(id);

        } catch (ResourceNotFoundException e) {
            return null;
        }
    }
}
