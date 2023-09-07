package com.example.consultantapp.Controller;

import com.example.consultantapp.DTO.LoginRequestDTO;
import com.example.consultantapp.DTO.LoginResponseDTO;
import com.example.consultantapp.Service.LoginDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/logindetails")
@CrossOrigin("http://localhost:3000")
public class LoginDetailsController {
    @Autowired
    private LoginDetailsService loginDetailsService;

    @PostMapping("/validateemail")
    public ResponseEntity<?> validateEmail(@RequestBody String email){
        Map<String, Object> map = new LinkedHashMap<>();
        boolean valid = loginDetailsService.validateEmail(email);

        if (valid) {
            map.put("status", 1);
            map.put("message", "Email is available");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Email is not available");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginData){
        Map<String, Object> map = new HashMap<>();
        LoginResponseDTO loginResponse = loginDetailsService.login(loginData);

        if (loginResponse!=null) {
            map.put("status", 1);
            map.put("data", loginResponse);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Login failed");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
