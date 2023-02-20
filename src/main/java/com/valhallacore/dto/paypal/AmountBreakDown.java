package com.valhallacore.dto.paypal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonAutoDetect
public class AmountBreakDown {
    @JsonProperty("item_total")
    private Money itemTotal;
    private Money discount;
    private Money handling;
    private Money insurance;
    @JsonProperty("tax_total")
    private Money taxTotal;
}
