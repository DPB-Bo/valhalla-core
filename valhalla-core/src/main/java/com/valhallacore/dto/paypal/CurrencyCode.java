package com.valhallacore.dto.paypal;

public enum CurrencyCode {
    VND("VND"),
    USD("USD");
    private String code;
    CurrencyCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
