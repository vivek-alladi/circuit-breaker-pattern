package com.microservices.orderservice.service;

import com.microservices.orderservice.Client.InventoryClient;
import com.microservices.orderservice.Client.ProductClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private ProductClient productClient;
    @Autowired
    private InventoryClient inventoryClient;

    @CircuitBreaker(name = "inventoryCount", fallbackMethod = "handleFailure")
    public String placeOrder(String id) {
        log.info("calling inventory client");
        var inventory = inventoryClient.getInventory(id);

        if (inventory.getCount().equals(0)) {
            return "Out of Stock";
        }
        inventoryClient.updateInventory(id);
        return "Order placed successfully";
    }

    public String handleFailure(Throwable t) {
        log.error("inside fallbackplaceorder, cause - {}", t.toString());
        return "inventory service unable to handle requests at the moment. Try again later";
    }


}
