package com.ironhack.productscurrency.currencyservice.controller.dto;

public class CurrencyChangerDTO {
    private Double price;
    private String currency;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
