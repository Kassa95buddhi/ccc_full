package com.example.consultantapp.Service;

import com.example.consultantapp.DTO.UserDTO;
import com.example.consultantapp.DTO.UserFullDTO;

public interface UserService {
    UserDTO addUser(UserFullDTO userData);
}
