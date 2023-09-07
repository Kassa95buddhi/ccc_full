package com.example.consultantapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="jobSeeker")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobSeekerId;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", unique = true)
    private User user;
    @OneToOne(mappedBy = "jobSeeker", cascade = CascadeType.REMOVE)
    private Qualification qualification;
    @OneToOne(mappedBy = "jobSeeker", cascade = CascadeType.REMOVE)
    private Appointment appointment;
}
