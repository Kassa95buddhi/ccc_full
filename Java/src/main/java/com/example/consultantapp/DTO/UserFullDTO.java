package com.example.consultantapp.DTO;

import com.example.consultantapp.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFullDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private int mobile;
    private Role role;
    private String email;
    private String password;
}
