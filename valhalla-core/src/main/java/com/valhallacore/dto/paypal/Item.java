package com.valhallacore.dto.paypal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.valhallacore.dto.bo.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private String name;
    private String quantity;
    @JsonProperty("unit_amount")
    private Money unitAmount;
    private Category category;
    private String description;
}
