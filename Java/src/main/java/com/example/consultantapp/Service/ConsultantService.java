package com.example.consultantapp.Service;

import com.example.consultantapp.DTO.ConsultantDTO;
import com.example.consultantapp.DTO.ConsultantFullDTO;

public interface ConsultantService {
    ConsultantDTO addConsultant(ConsultantFullDTO data);
}
