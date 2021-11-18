package com.ironhack.productscurrency.edgeservice.service.impl;

import com.ironhack.productscurrency.edgeservice.client.CurrencyClient;
import com.ironhack.productscurrency.edgeservice.client.ProductClient;
import com.ironhack.productscurrency.edgeservice.controller.dto.Product;
import com.ironhack.productscurrency.edgeservice.controller.dto.ProductDTO;
import com.ironhack.productscurrency.edgeservice.service.interfaces.IEdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdgeService implements IEdgeService {

    @Autowired
    private CurrencyClient currencyClient;

    @Autowired
    private ProductClient productClient;

    public ProductDTO getProductWithCurrency(Long id, String currency) {
        Product product = productClient.get(id);
        Double price = currencyClient.changeCurrency(product.getPrice(), currency);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(price);
        return productDTO;
    }
}
