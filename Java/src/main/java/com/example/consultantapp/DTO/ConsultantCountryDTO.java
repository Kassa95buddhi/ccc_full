package com.example.consultantapp.DTO;

import com.example.consultantapp.Model.Consultant;
import com.example.consultantapp.Model.Country;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ConsultantCountryDTO {
    private int consultantCountryId;
    private int consultantConsultantId;
    private Country countryCountryId;
}
