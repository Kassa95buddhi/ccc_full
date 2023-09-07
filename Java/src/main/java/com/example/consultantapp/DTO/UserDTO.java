package com.example.consultantapp.DTO;

import com.example.consultantapp.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private int mobile;
    private Role role;
}
