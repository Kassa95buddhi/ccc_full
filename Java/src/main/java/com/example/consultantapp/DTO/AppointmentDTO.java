package com.example.consultantapp.DTO;

import com.example.consultantapp.Enum.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDTO {
    private int appointmentId;
    private boolean appointmentStatus;
    private int consultantConsultantId;
    private int jobSeekerJobSeekerId;
}
