package com.example.consultantapp.DTO;

import com.example.consultantapp.Model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobSeekerDTO {
    private int jobSeekerId;
    private int userUserId;
}
