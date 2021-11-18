package com.ironhack.productscurrency.edgeservice.client;

import com.ironhack.productscurrency.edgeservice.controller.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductClient {
    @GetMapping("/products/{id}")
    Product get(@PathVariable Long id);
}
