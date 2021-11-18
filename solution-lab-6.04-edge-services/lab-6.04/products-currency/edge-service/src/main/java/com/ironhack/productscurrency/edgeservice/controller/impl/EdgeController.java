package com.ironhack.productscurrency.edgeservice.controller.impl;

import com.ironhack.productscurrency.edgeservice.controller.dto.ProductDTO;
import com.ironhack.productscurrency.edgeservice.controller.interfaces.IEdgeController;
import com.ironhack.productscurrency.edgeservice.service.interfaces.IEdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdgeController implements IEdgeController {

    @Autowired
    private IEdgeService edgeService;

    @GetMapping("products")
    public ProductDTO getProductWithCurrency(@RequestParam Long id, @RequestParam String currency) {
        return edgeService.getProductWithCurrency(id, currency);
    }
}
