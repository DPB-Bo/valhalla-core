package com.valhallacore.dto.bo;

import com.valhallacore.utils.DiscountUtil;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Long id;
    private String name;
    private String description;
    private Long quantityAvailable;
    private int quantity;
    private int subTotal;
    private double salePrice;
    private double discountPercentage;
    private double originalPrice;

    public double getDiscountPercentage() {
        return DiscountUtil.getDiscountPercentage(originalPrice, salePrice);
    }
}
