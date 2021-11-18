package com.ironhack.productscurrency.productservice.controller.impl;

import com.ironhack.productscurrency.productservice.controller.interfaces.IProductController;
import com.ironhack.productscurrency.productservice.model.Product;
import com.ironhack.productscurrency.productservice.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements IProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products/{id}")
    public Product get(@PathVariable Long id) {
        return productService.get(id);
    }
}
