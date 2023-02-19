package com.valhallacore.dto.paypal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Money {
    public Money(String value) {
        this.value = value;
    }
    private String value;
    @JsonProperty("currency_code")
    private String currencyCode;
}
