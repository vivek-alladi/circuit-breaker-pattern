package com.microservices.orderservice.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product-service", url = "${service.product.path}")
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/validate/{id}")
    Boolean validateProductId(@PathVariable String id);
}
