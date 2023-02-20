package com.valhallacore.dto.bo;

import com.valhallacore.Enum.UserType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemUser {
    private Long id;
    private String username;
    private UserType userType;
    private String fullName;
    private Date birthDay;
    private String email;
    private String phone;
}
