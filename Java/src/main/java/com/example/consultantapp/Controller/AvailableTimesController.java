package com.example.consultantapp.Controller;

import com.example.consultantapp.DTO.AvailableTimesDTO;
import com.example.consultantapp.DTO.ConsultantDTO;
import com.example.consultantapp.DTO.ConsultantFullDTO;
import com.example.consultantapp.Service.AvailableTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/availableTimes")
@CrossOrigin("http://localhost:3000")
public class AvailableTimesController {
    @Autowired
    private AvailableTimesService availableTimesService;

    @PostMapping("/addavailabletimes")
    public ResponseEntity<?> addAvailableTimes(@RequestBody AvailableTimesDTO data){
        Map<String, Object> map = new LinkedHashMap<>();
        AvailableTimesDTO availableTimes = availableTimesService.addAvailableTimes(data);

        if (availableTimes!=null) {
            map.put("status", 1);
            map.put("data", availableTimes);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Consultant Adding Failed");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @GetMapping("/getavailabletimesbyconsultantid/{consultantId}")
    public ResponseEntity<?> getAvailableTimesByConsultantId(@PathVariable int consultantId){
        Map<String, Object> map = new LinkedHashMap<>();
        List<AvailableTimesDTO> list = availableTimesService.getAvailableTimesByConsultantId(consultantId);

        if (!list.isEmpty()) {
            map.put("status", 1);
            map.put("data", list);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "No Available Dates");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
