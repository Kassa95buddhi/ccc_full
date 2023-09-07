package com.example.consultantapp.DTO;

import com.example.consultantapp.Enum.Role;
import com.example.consultantapp.Model.Consultant;
import com.example.consultantapp.Model.JobSeeker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private int mobile;
    private Role role;
    private String email;
    private int jobSeekerId;
    private int consultantId;
    private String jobType;
    private boolean status;
}
