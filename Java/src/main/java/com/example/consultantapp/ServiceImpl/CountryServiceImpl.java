package com.example.consultantapp.ServiceImpl;

import com.example.consultantapp.DTO.ConsultantDTO;
import com.example.consultantapp.DTO.CountryDTO;
import com.example.consultantapp.DTO.UserDTO;
import com.example.consultantapp.DTO.UserFullDTO;
import com.example.consultantapp.Enum.Role;
import com.example.consultantapp.Model.Consultant;
import com.example.consultantapp.Model.Country;
import com.example.consultantapp.Model.User;
import com.example.consultantapp.Repository.CountryRepository;
import com.example.consultantapp.Service.CountryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CountryDTO addCountry(CountryDTO countryData) {
        try{
            Country country = modelMapper.map(countryData, Country.class);
            Country newCountry = countryRepository.save(country);
            if(newCountry!=null){
                return modelMapper.map(newCountry, new TypeToken<CountryDTO>() {}.getType());
            }
            return null;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        try{
            List<Country> list = countryRepository.findAll();
            return modelMapper.map(list, new TypeToken<List<CountryDTO>>() {
            }.getType());
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
