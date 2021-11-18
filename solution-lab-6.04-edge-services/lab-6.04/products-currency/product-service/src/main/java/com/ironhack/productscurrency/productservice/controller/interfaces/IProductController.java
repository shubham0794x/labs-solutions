package com.ironhack.productscurrency.productservice.controller.interfaces;

import com.ironhack.productscurrency.productservice.model.Product;

public interface IProductController {
    Product get(Long id);
}
