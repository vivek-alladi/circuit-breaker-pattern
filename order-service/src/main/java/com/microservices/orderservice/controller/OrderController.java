package com.microservices.orderservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservices.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place/{id}")
    public ResponseEntity<String> placeOrder(@PathVariable String id) throws JsonProcessingException {
        return ResponseEntity.ok(orderService.placeOrder(id));
    }
}
