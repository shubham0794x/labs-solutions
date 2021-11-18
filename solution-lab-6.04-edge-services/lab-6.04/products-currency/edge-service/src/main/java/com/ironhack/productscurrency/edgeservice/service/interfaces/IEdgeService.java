package com.ironhack.productscurrency.edgeservice.service.interfaces;

import com.ironhack.productscurrency.edgeservice.controller.dto.ProductDTO;

public interface IEdgeService {
    ProductDTO getProductWithCurrency(Long id, String currency);
}
