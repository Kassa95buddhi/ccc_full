package com.example.consultantapp.DTO;

import com.example.consultantapp.Model.JobSeeker;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QualificationDTO {
    private int qualificationId;
    private int jobSeekerJobSeekerId;
    private String qualification;
}
