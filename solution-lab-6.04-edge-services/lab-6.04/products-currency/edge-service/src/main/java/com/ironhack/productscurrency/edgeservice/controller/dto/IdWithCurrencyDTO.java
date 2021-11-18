package com.ironhack.productscurrency.edgeservice.controller.dto;

public class IdWithCurrencyDTO {
    private Long id;
    private String currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
