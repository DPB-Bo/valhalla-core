package com.valhallacore.entity.bo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity extends SystemUserEntity {
    private Date joinedDay;
    private Double point;
}
