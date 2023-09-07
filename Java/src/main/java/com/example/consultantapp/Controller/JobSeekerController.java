package com.example.consultantapp.Controller;

import com.example.consultantapp.DTO.JobSeekerDTO;
import com.example.consultantapp.DTO.JobSeekerFullDTO;
import com.example.consultantapp.Service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/jobseeker")
@CrossOrigin("http://localhost:3000")
public class JobSeekerController {
    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping("/addjobseeker")
    public ResponseEntity<?> addJobSeeker(@RequestBody JobSeekerFullDTO data){
        Map<String, Object> map = new LinkedHashMap<>();
        JobSeekerDTO seeker = jobSeekerService.addJobSeeker(data);

        if (seeker!=null) {
            map.put("status", 1);
            map.put("data", seeker);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Job Seeker Adding Failed");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }


}
