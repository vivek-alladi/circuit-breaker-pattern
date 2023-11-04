package com.microservices.inventoryservice.dto;

public class InventoryResponse {
    private String count;

    public InventoryResponse(String count) {
        this.count = count;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
