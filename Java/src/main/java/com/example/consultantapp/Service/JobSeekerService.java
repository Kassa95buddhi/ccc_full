package com.example.consultantapp.Service;

import com.example.consultantapp.DTO.JobSeekerDTO;
import com.example.consultantapp.DTO.JobSeekerFullDTO;

public interface JobSeekerService {
    JobSeekerDTO addJobSeeker(JobSeekerFullDTO data);
}
