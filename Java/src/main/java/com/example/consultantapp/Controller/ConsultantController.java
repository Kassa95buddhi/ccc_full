package com.example.consultantapp.Controller;

import com.example.consultantapp.DTO.ConsultantDTO;
import com.example.consultantapp.DTO.ConsultantFullDTO;
import com.example.consultantapp.DTO.JobSeekerDTO;
import com.example.consultantapp.Service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/consultant")
@CrossOrigin("http://localhost:3000")
public class ConsultantController {
    @Autowired
    private ConsultantService consultantService;

    @PostMapping("/addconsultant")
    public ResponseEntity<?> addConsultant(@RequestBody ConsultantFullDTO data){
        Map<String, Object> map = new LinkedHashMap<>();
        ConsultantDTO consultant = consultantService.addConsultant(data);

        if (consultant!=null) {
            map.put("status", 1);
            map.put("data", consultant);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Consultant Adding Failed");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
