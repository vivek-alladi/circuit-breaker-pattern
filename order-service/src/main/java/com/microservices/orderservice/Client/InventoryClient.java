package com.microservices.orderservice.Client;

import com.microservices.orderservice.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "inventory-service", url = "${service.inventory.path}")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    InventoryResponse getInventory(@PathVariable String id);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    InventoryResponse updateInventory(@PathVariable String id);

}
