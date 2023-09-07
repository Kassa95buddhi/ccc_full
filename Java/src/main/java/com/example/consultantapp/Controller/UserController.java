package com.example.consultantapp.Controller;

import com.example.consultantapp.DTO.UserDTO;
import com.example.consultantapp.DTO.UserFullDTO;
import com.example.consultantapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<?> addUser(@RequestBody UserFullDTO userData){
        Map<String, Object> map = new LinkedHashMap<>();
        UserDTO user = userService.addUser(userData);

        if (user!=null) {
            map.put("status", 1);
            map.put("data", user);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "User Registration Failed");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }


}
