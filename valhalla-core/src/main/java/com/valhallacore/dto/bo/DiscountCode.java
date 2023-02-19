package com.valhallacore.dto.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCode {
    private String code;
    private String description;
    private Date createdDate;
    private Date expiredDate;
    private double amount;
    private double stock;
    private SystemUser author;
    private Date lastModifier;
}
