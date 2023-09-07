package com.example.consultantapp.ServiceImpl;

import com.example.consultantapp.Repository.AppointmentRepository;
import com.example.consultantapp.Service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ModelMapper modelMapper;
}
