package com.microservices.productservice.dto;

public class ProductResponse {
    private String message;
    private String id;

    public ProductResponse(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "message='" + message + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
