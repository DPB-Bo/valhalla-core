package com.valhallacore.dto;

import com.valhallacore.dto.paypal.CurrencyCode;

public class Constant {
    private Constant() {
    }

    public static final String WHITE_SPACE = " ";
    public static final String EMPTY_STRING = "";
    public static final String SANDBOX = "sandbox";
    public static final String USD = CurrencyCode.USD.getCode();
}
