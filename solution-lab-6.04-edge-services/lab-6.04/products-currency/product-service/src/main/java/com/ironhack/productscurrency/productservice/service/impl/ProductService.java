package com.ironhack.productscurrency.productservice.service.impl;

import com.ironhack.productscurrency.productservice.model.Product;
import com.ironhack.productscurrency.productservice.repository.ProductRepository;
import com.ironhack.productscurrency.productservice.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product get(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with id " + id + " not found.");
        }
        return product.get();
    }
}
