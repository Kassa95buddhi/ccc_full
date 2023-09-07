package com.example.consultantapp.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name="consultant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consultant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consultantId;
    private String jobType;
    private boolean status;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", unique = true)
    private User user;
    @OneToOne(mappedBy = "consultant", cascade = CascadeType.REMOVE)
    private Appointment appointment;
    @OneToMany(mappedBy = "consultant", cascade = CascadeType.REMOVE)
    private List<AvailableTimes> availableTimes;

    @OneToMany(mappedBy = "consultant", cascade = CascadeType.REMOVE)
    private List<ConsultantCountry> consultantCountries;
}
