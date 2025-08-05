package com.Payment_System_API.payment_system_api.DTO;

import com.Payment_System_API.payment_system_api.Model.Enums.UserRole;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private boolean status;
    private UserRole role;
}
