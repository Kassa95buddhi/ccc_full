package com.example.consultantapp.Service;

import com.example.consultantapp.DTO.AvailableTimesDTO;

import java.util.List;

public interface AvailableTimesService {
    AvailableTimesDTO addAvailableTimes(AvailableTimesDTO data);

    List<AvailableTimesDTO> getAvailableTimesByConsultantId(int consultantId);
}
