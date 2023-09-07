package com.example.consultantapp.ServiceImpl;

import com.example.consultantapp.Repository.ConsultantCountryRepository;
import com.example.consultantapp.Service.ConsultantCountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultantCountryServiceImpl implements ConsultantCountryService {
    @Autowired
    private ConsultantCountryRepository consultantCountryRepository;
    @Autowired
    private ModelMapper modelMapper;
}
