package com.valhallacore.dto.bo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientOrder {
    private List<Product> products;
    private Customer customer;
    private DiscountCode discountCode;
    private double totalPrice;
    private double originalPrice;
}
