package com.ironhack.productscurrency.currencyservice.service.impl;

import com.ironhack.productscurrency.currencyservice.service.interfaces.ICurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CurrencyService implements ICurrencyService {

    public Double changeCurrency(Double price, String currency) {
        switch (currency) {
            case "USD":
                return price;
            case "EUR":
                return price * 0.83;
            case "JPY":
                return price * 105.87;
            case "CNY":
                return price * 6.46;
            case "GBP":
                return price * 0.72;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Currency not supported.");
    }
}
