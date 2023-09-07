package com.example.consultantapp.Controller;

import com.example.consultantapp.Service.ConsultantCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultantcountry")
@CrossOrigin("http://localhost:3000")
public class ConsultantCountryController {
    @Autowired
    private ConsultantCountryService consultantCountryService;
}
