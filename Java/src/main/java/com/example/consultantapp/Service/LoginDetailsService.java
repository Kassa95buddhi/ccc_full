package com.example.consultantapp.Service;

import com.example.consultantapp.DTO.LoginRequestDTO;
import com.example.consultantapp.DTO.LoginResponseDTO;

public interface LoginDetailsService {
    boolean validateEmail(String email);
    LoginResponseDTO login(LoginRequestDTO loginData);
}
