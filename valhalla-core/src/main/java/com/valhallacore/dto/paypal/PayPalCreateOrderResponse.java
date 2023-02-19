package com.valhallacore.dto.paypal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayPalCreateOrderResponse extends PayPalOrder{
    private String id;
    private OrderStatus status;
    @JsonProperty("create_time")
    private Date createTime;
    @JsonProperty("links")
    private List<LinkDescription> links;
}
