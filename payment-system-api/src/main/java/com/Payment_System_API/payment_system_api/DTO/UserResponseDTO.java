package com.Payment_System_API.payment_system_api.DTO;

import com.Payment_System_API.payment_system_api.Model.Enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    //@Enumerated(EnumType.STRING)
    private UserRole role;


}
