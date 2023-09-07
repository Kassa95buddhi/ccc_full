package com.example.consultantapp.Service;

import com.example.consultantapp.DTO.CountryDTO;

import java.util.List;

public interface CountryService {
    CountryDTO addCountry(CountryDTO data);

    List<CountryDTO> getAllCountries();
}
