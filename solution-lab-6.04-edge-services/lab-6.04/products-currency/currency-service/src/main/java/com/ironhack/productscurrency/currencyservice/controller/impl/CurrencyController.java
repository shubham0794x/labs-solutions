package com.ironhack.productscurrency.currencyservice.controller.impl;

import com.ironhack.productscurrency.currencyservice.controller.interfaces.ICurrencyController;
import com.ironhack.productscurrency.currencyservice.service.interfaces.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController implements ICurrencyController {

    @Autowired
    private ICurrencyService currencyService;

    @GetMapping("/change-currency")
    public Double changeCurrency(@RequestParam Double price, @RequestParam String currency) {
        return currencyService.changeCurrency(price, currency);
    }
}
