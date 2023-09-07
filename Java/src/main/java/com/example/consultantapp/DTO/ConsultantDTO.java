package com.example.consultantapp.DTO;

import com.example.consultantapp.Model.Country;
import com.example.consultantapp.Model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultantDTO {
    private int consultantId;
    private String jobType;
    private boolean status;
    private int userUserId;
}
