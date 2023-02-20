package com.valhallacore.entity.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.valhallacore.dto.bo.Product;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CustomerEntity customer;
    @OneToMany(mappedBy = "customerOrder")
    @JsonBackReference
    private Set<OrderDetailEntity> productEntitySet;
    private double totalPrice;
    private double originalPrice;
    @ManyToOne
    private DiscountCodeEntity discountCode;
}
