package com.example.consultantapp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailableTimesDTO {
    private int availableTimeId;
    private String availableDate;
    private String availableTime;
    private int consultantConsultantId;
}
