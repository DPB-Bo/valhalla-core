package com.valhallacore.entity.bo;

import com.valhallacore.Enum.UserType;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class SystemUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private UserType userType;
    private String fullName;
    private Date birthDay;
    private String email;
    private String phone;

}
