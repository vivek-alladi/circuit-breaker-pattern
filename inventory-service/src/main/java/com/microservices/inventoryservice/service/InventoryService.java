package com.microservices.inventoryservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.inventoryservice.dto.InventoryResponse;
import com.microservices.inventoryservice.entity.Inventory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class InventoryService {
    public InventoryResponse getInventoryDetail(String id) throws IOException {
        List<Inventory> inventories = getInventories();

            List<Inventory> inventories1 = inventories.stream().filter((inventory) -> {
                return inventory.getId().equals(id);
            }).toList();

            if(inventories1.isEmpty()) {
                throw new RuntimeException();
            }

            return new InventoryResponse(String.valueOf(inventories1.get(0).getCount()));
    }

    private static List<Inventory> getInventories() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("/Users/vivek/Documents/Projects/circuit-breaker-pattern/inventory-service/src/main/resources/testData/inventoryList.json");
        List<Inventory> inventories = mapper.readValue(file, new TypeReference<>() {
        });
        return inventories;
    }

    public InventoryResponse updateInventory(String id) throws IOException {
        List<Inventory> inventories = getInventories();

       for(Inventory inventory: inventories) {
           if(inventory.getId().equals(id)) {
               int count = inventory.setCount(inventory.getCount() - 1);
               return new InventoryResponse(String.valueOf(count));
           }
       }
       throw new RuntimeException();
    }
}
