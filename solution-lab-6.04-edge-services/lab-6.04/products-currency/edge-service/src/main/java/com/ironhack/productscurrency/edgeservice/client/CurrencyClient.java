package com.ironhack.productscurrency.edgeservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("currency-service")
public interface CurrencyClient {
    @GetMapping("/change-currency")
    Double changeCurrency(@RequestParam Double price, @RequestParam String currency);
}
