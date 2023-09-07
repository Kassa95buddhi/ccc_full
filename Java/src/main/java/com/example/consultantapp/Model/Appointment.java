package com.example.consultantapp.Model;

import com.example.consultantapp.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    private boolean appointmentStatus;
    @OneToOne
    @JoinColumn(name = "consultantId", referencedColumnName = "consultantId", unique = true)
    private Consultant consultant;
    @OneToOne
    @JoinColumn(name = "jobSeekerId", referencedColumnName = "jobSeekerId", unique = true)
    private JobSeeker jobSeeker;

    @OneToOne
    @JoinColumn(name = "availableTimeId", referencedColumnName = "availableTimeId", unique = true)
    private AvailableTimes availableTimes;
}
