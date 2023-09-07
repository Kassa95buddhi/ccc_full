package com.example.consultantapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ConsultantCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consultantCountryId;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "consultantId", referencedColumnName = "consultantId", nullable = false)
    private Consultant consultant;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "countryId", referencedColumnName = "countryId", nullable = false)
    private Country country;
}
