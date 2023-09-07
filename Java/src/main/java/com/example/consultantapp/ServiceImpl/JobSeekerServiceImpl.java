package com.example.consultantapp.ServiceImpl;

import com.example.consultantapp.DTO.*;
import com.example.consultantapp.Enum.Role;
import com.example.consultantapp.Model.JobSeeker;
import com.example.consultantapp.Model.User;
import com.example.consultantapp.Repository.JobSeekerRepository;
import com.example.consultantapp.Repository.UserRepository;
import com.example.consultantapp.Service.JobSeekerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public JobSeekerDTO addJobSeeker(JobSeekerFullDTO data) {
        try{
            UserFullDTO userFullDto = new UserFullDTO();
            userFullDto.setFirstName(data.getFirstName());
            userFullDto.setLastName(data.getLastName());
            userFullDto.setMobile(data.getMobile());
            userFullDto.setRole(Role.JOBSEEKER);
            userFullDto.setEmail(data.getEmail());
            userFullDto.setPassword(data.getPassword());

            UserDTO newUserDto = userServiceImpl.addUser(userFullDto);
            if(newUserDto!=null){
                User user = modelMapper.map(newUserDto, User.class);

                JobSeeker jobSeeker=new JobSeeker();
                jobSeeker.setUser(user);
                JobSeeker newJobSeeker = jobSeekerRepository.save(jobSeeker);

                if(newJobSeeker!=null){
                    return modelMapper.map(newJobSeeker, new TypeToken<JobSeekerDTO>() {}.getType());
                }
            }
            return null;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    public JobSeekerDTO registerJobSeeker(User userData) {
        try{
            JobSeeker jobSeeker = new JobSeeker();
            jobSeeker.setUser(userData);

            JobSeeker newJobSeeker = jobSeekerRepository.save(jobSeeker);
            if(newJobSeeker!=null){
                return modelMapper.map(newJobSeeker, new TypeToken<JobSeekerDTO>() {}.getType());
            }
            return null;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
