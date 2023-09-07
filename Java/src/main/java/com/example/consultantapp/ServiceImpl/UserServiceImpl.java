package com.example.consultantapp.ServiceImpl;

import com.example.consultantapp.DTO.JobSeekerDTO;
import com.example.consultantapp.DTO.LoginDetailsDTO;
import com.example.consultantapp.DTO.UserDTO;
import com.example.consultantapp.DTO.UserFullDTO;
import com.example.consultantapp.Enum.Role;
import com.example.consultantapp.Model.JobSeeker;
import com.example.consultantapp.Model.LoginDetails;
import com.example.consultantapp.Model.User;
import com.example.consultantapp.Repository.LoginDetailsRepository;
import com.example.consultantapp.Repository.UserRepository;
import com.example.consultantapp.Service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;
    @Autowired
    private LoginDetailsServiceImpl loginDetailsServiceImpl;
    @Autowired
    private JobSeekerServiceImpl jobSeekerServiceImpl;
    @Override
    public UserDTO addUser(UserFullDTO userData) {
        try{
            boolean validEmail = loginDetailsServiceImpl.validateEmail(userData.getEmail());
            if(validEmail){
                 User user = modelMapper.map(userData, User.class);
                 User newUser = userRepository.save(user);
                 if(newUser!=null){
                     LoginDetailsDTO ld = loginDetailsServiceImpl.addLoginDetails(userData,user);
                     if(ld!=null){
                         return modelMapper.map(user, new TypeToken<UserDTO>() {}.getType());
                     }
                     else{
                         userRepository.deleteByUserIdEquals(newUser.getUserId());
                     }
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
