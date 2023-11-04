package com.microservices.inventoryservice.entity;

import org.springframework.stereotype.Component;

@Component
public class Inventory {
    private String id;
    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public int setCount(int count) {
        this.count = count;
        return count;
    }
}
