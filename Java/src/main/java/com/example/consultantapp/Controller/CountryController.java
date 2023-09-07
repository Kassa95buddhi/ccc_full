package com.example.consultantapp.Controller;

import com.example.consultantapp.DTO.ConsultantDTO;
import com.example.consultantapp.DTO.ConsultantFullDTO;
import com.example.consultantapp.DTO.CountryDTO;
import com.example.consultantapp.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/country")
@CrossOrigin("http://localhost:3000")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/addcountry")
    public ResponseEntity<?> addCountry(@RequestBody CountryDTO data){
        Map<String, Object> map = new LinkedHashMap<>();
        CountryDTO country = countryService.addCountry(data);

        if (country!=null) {
            map.put("status", 1);
            map.put("data", country);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Consultant Adding Failed");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @GetMapping("/getallcountires")
    public ResponseEntity<?> getAllCountries(){
        Map<String, Object> map = new LinkedHashMap<>();
        List<CountryDTO> countries = countryService.getAllCountries();

        if (!countries.isEmpty()) {
            map.put("status", 1);
            map.put("data", countries);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Consultant Adding Failed");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
