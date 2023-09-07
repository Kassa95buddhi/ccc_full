package com.example.consultantapp.ServiceImpl;

import com.example.consultantapp.DTO.*;
import com.example.consultantapp.Enum.Role;
import com.example.consultantapp.Model.Consultant;
import com.example.consultantapp.Model.JobSeeker;
import com.example.consultantapp.Model.User;
import com.example.consultantapp.Repository.ConsultantRepository;
import com.example.consultantapp.Service.ConsultantService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultantServiceImpl implements ConsultantService {

    @Autowired
    private ConsultantRepository consultantRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ConsultantDTO addConsultant(ConsultantFullDTO data) {
        try{
            UserFullDTO userFullDto = new UserFullDTO();
            userFullDto.setFirstName(data.getFirstName());
            userFullDto.setLastName(data.getLastName());
            userFullDto.setMobile(data.getMobile());
            userFullDto.setRole(Role.CONSULTANT);
            userFullDto.setEmail(data.getEmail());
            userFullDto.setPassword(data.getPassword());

            UserDTO newUserDto = userServiceImpl.addUser(userFullDto);
            if(newUserDto!=null){
                User user = modelMapper.map(newUserDto, User.class);

                Consultant consultantData=new Consultant();
                consultantData.setUser(user);
                Consultant newConsultant = consultantRepository.save(consultantData);

                if(newConsultant!=null){
                    return modelMapper.map(newConsultant, new TypeToken<ConsultantDTO>() {}.getType());
                }
            }
            return null;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
