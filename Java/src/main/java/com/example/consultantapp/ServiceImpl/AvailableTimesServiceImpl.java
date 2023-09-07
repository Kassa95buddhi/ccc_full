package com.example.consultantapp.ServiceImpl;

import com.example.consultantapp.DTO.AvailableTimesDTO;
import com.example.consultantapp.DTO.CountryDTO;
import com.example.consultantapp.Model.AvailableTimes;
import com.example.consultantapp.Model.Country;
import com.example.consultantapp.Repository.AvailableTimesRepository;
import com.example.consultantapp.Service.AvailableTimesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableTimesServiceImpl implements AvailableTimesService {

    @Autowired
    private AvailableTimesRepository availableTimesServiceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AvailableTimesDTO addAvailableTimes(AvailableTimesDTO data) {
        try{
            AvailableTimes availableTimes = modelMapper.map(data, AvailableTimes.class);
            AvailableTimes newAvailableTimes = availableTimesServiceRepository.save(availableTimes);
            if(newAvailableTimes!=null){
                return modelMapper.map(newAvailableTimes, new TypeToken<AvailableTimesDTO>() {}.getType());
            }
            return null;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public List<AvailableTimesDTO> getAvailableTimesByConsultantId(int consultantId) {
        try{
            List<AvailableTimes> list = availableTimesServiceRepository.getAvailableTimesByConsultantId(consultantId);
            return modelMapper.map(list, new TypeToken<List<AvailableTimesDTO>>() {
            }.getType());
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
