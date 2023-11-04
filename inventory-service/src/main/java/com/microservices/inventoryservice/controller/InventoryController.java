package com.microservices.inventoryservice.controller;

import com.microservices.inventoryservice.dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.inventoryservice.service.InventoryService;

import java.io.IOException;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponse> getInventory(@PathVariable String id) throws IOException {
        return ResponseEntity.ok(inventoryService.getInventoryDetail(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryResponse> updateInventory(@PathVariable String id) throws IOException {
        return ResponseEntity.ok(inventoryService.updateInventory(id));
    }
}
