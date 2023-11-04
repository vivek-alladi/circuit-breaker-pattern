package com.microservices.orderservice.service;

import com.microservices.orderservice.Client.InventoryClient;
import com.microservices.orderservice.Client.ProductClient;
import com.microservices.orderservice.dto.InventoryResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ProductClient productClient;
    @Autowired
    private InventoryClient inventoryClient;

    public String placeOrder(String id) {
        try {
            Boolean validate = productClient.validateProductId(id);
        } catch (FeignException e) {
        return "exception";
        }

        var inventory = inventoryClient.getInventory(id);
        if(inventory.getCount().equals(0)) {
            return "Out of Stock";
        }
        inventoryClient.updateInventory(id);
        return "Order places successfully";

    }
}
