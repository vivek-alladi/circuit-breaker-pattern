package com.microservices.productservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;
import com.microservices.productservice.entity.Product;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    public ProductResponse addProduct(ProductRequest productRequest) throws IOException {
        List<Product> productList = getProductList();

        UUID uuid = UUID.randomUUID();
        productList.add(new Product(uuid.toString(), productRequest.getName(), productRequest.getPrice()));
        System.out.println(productList);

        return new ProductResponse("product created successfully", String.valueOf(uuid));
    }

    private static List<Product> getProductList() throws IOException {
        File file = new File("/Users/vivek/Documents/Projects/circuit-breaker-pattern/product-service/src/main/resources/testData/productList.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Product> productList = mapper.readValue(file, new TypeReference<>() {});
        return productList;
    }

    public List<ProductResponse> getProducts() throws IOException {
        List<Product> productList = getProductList();

        List<ProductResponse> productResponses = productList.stream().map(product -> {
            return new ProductResponse(product.getName(), product.getId());
        }).toList();

        return productResponses;
    }

    public Boolean validateProductId(String id) throws IOException {
        List<Product> productList = getProductList();

        for(Product product: productList) {
            if(product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
