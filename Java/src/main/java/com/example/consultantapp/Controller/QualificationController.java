package com.example.consultantapp.Controller;

import com.example.consultantapp.DTO.JobSeekerDTO;
import com.example.consultantapp.DTO.QualificationDTO;
import com.example.consultantapp.Service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/qualification")
@CrossOrigin("http://localhost:3000")
public class QualificationController {
    @Autowired
    private QualificationService qualificationService;

    @PostMapping("/addqualification")
    public ResponseEntity<?> addQualification(@RequestBody QualificationDTO data){
        Map<String, Object> map = new LinkedHashMap<>();
        QualificationDTO qualification = qualificationService.addQualification(data);

        if (qualification!=null) {
            map.put("status", 1);
            map.put("data", qualification);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Job Seeker Adding Failed");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
