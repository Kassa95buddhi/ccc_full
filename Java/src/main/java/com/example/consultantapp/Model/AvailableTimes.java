package com.example.consultantapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="AvailableTimes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availableTimeId;
    private String availableDate;
    private String availableTime;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "consultantId", referencedColumnName = "consultantId", nullable = false)
    private Consultant consultant;

    @OneToOne(mappedBy = "availableTimes", cascade = CascadeType.REMOVE)
    private Appointment appointment;

}
