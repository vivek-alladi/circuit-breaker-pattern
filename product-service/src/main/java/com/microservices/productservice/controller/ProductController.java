package com.microservices.productservice.controller;

import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;
import com.microservices.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) throws IOException {
        return ResponseEntity.ok(productService.addProduct(productRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getProducts() throws IOException {
        return ResponseEntity.ok(productService.getProducts());
    }

}
