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
public class Payee {
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("merchant_id")
    private String merchantId;
}
