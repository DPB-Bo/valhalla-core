package com.valhallacore.dto.paypal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Urls {
    private String cancel;
    private String success;
    private String createOrder;
}
