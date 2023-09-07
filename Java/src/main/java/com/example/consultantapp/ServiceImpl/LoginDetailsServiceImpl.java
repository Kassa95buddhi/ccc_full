package com.example.consultantapp.ServiceImpl;

import com.example.consultantapp.DTO.LoginDetailsDTO;
import com.example.consultantapp.DTO.LoginRequestDTO;
import com.example.consultantapp.DTO.LoginResponseDTO;
import com.example.consultantapp.DTO.UserFullDTO;
import com.example.consultantapp.Enum.Role;
import com.example.consultantapp.Model.Consultant;
import com.example.consultantapp.Model.JobSeeker;
import com.example.consultantapp.Model.LoginDetails;
import com.example.consultantapp.Model.User;
import com.example.consultantapp.Repository.ConsultantRepository;
import com.example.consultantapp.Repository.JobSeekerRepository;
import com.example.consultantapp.Repository.LoginDetailsRepository;
import com.example.consultantapp.Repository.UserRepository;
import com.example.consultantapp.Service.LoginDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDetailsServiceImpl implements LoginDetailsService {
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    @Autowired
    private ConsultantRepository consultantRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean validateEmail(String email){
        boolean valid=false;
        try{
            LoginDetails logindetails = loginDetailsRepository.validateEmail(email);
            if(logindetails==null){
                valid=true;
            }
            return valid;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return valid;
        }
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginData) {
        try{
            LoginDetails loginDetails=loginDetailsRepository.getLoginData(loginData.getEmail(),loginData.getPassword());

            if(loginDetails!=null){
                User user=userRepository.getReferenceById(loginDetails.getUser().getUserId());

                if(user!=null){
                    if(user.getRole()== Role.JOBSEEKER){
                        JobSeeker jobSeeker = jobSeekerRepository.getJobSeekerByUserId(user.getUserId());
                        LoginResponseDTO response = LoginResponseDTO.builder().
                                userId(user.getUserId()).
                                firstName(user.getFirstName()).
                                lastName(user.getLastName()).
                                mobile(user.getMobile()).
                                role(user.getRole()).
                                email(loginDetails.getEmail()).
                                jobSeekerId(jobSeeker.getJobSeekerId()).
                                build();
                        return response;
                    } else if (user.getRole()== Role.CONSULTANT) {
                        Consultant consultant = consultantRepository.getConsultantByUserId(user.getUserId());
                        LoginResponseDTO response = LoginResponseDTO.builder().
                                userId(user.getUserId()).
                                firstName(user.getFirstName()).
                                lastName(user.getLastName()).
                                mobile(user.getMobile()).
                                role(user.getRole()).
                                email(loginDetails.getEmail()).
                                consultantId(consultant.getConsultantId()).
                                jobType(consultant.getJobType()).
                                status(consultant.isStatus()).
                                build();
                        return response;
                    }
                    else{
                        LoginResponseDTO response = LoginResponseDTO.builder().
                                userId(user.getUserId()).
                                firstName(user.getFirstName()).
                                lastName(user.getLastName()).
                                mobile(user.getMobile()).
                                role(user.getRole()).
                                email(loginDetails.getEmail()).build();
                        return response;
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

    public LoginDetailsDTO addLoginDetails(UserFullDTO userdata, User user){
        try{
            String hashedPW= userdata.getPassword();
            LoginDetails ld=new LoginDetails();
            ld.setEmail(userdata.getEmail());
            ld.setPassword(hashedPW);
            ld.setUser(user);

            LoginDetails newLd = loginDetailsRepository.save(ld);
            return modelMapper.map(ld, new TypeToken<LoginDetailsDTO>() {}.getType());
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
