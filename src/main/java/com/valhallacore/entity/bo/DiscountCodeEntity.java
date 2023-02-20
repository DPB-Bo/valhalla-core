package com.valhallacore.entity.bo;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DiscountCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String description;
    private Date createdDate;
    private Date expiredDate;
    private double amount;
    private double stock;
    private Date lastModifier;
    @ManyToOne
    private SystemUserEntity author;
}
