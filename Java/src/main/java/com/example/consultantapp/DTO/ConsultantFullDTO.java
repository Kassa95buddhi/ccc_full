package com.example.consultantapp.DTO;

import com.example.consultantapp.Enum.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConsultantFullDTO {
    private String firstName;
    private String lastName;
    private int mobile;
    private Role role;
    private String email;
    private String password;
    private String jobType;
    private boolean status;
}
