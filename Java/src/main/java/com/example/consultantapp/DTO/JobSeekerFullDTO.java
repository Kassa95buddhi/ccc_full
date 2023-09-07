package com.example.consultantapp.DTO;

import com.example.consultantapp.Enum.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobSeekerFullDTO {
    private String firstName;
    private String lastName;
    private int mobile;
    private Role role;
    private String email;
    private String password;
}
