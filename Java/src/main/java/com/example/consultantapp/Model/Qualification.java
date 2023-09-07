package com.example.consultantapp.Model;

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
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qualificationId;
    @OneToOne
    @JoinColumn(name = "jobSeekerId", referencedColumnName = "jobSeekerId", unique = true)
    private JobSeeker jobSeeker;

    private String qualification;
}
