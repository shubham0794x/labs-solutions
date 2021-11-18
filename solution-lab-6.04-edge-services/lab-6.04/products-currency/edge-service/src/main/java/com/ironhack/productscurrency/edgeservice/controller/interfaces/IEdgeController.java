package com.ironhack.productscurrency.edgeservice.controller.interfaces;

import com.ironhack.productscurrency.edgeservice.controller.dto.ProductDTO;

public interface IEdgeController {
    ProductDTO getProductWithCurrency(Long id, String currency);
}
