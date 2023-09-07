package com.example.consultantapp.ServiceImpl;

import com.example.consultantapp.DTO.QualificationDTO;
import com.example.consultantapp.Model.Qualification;
import com.example.consultantapp.Repository.QualificationRepository;
import com.example.consultantapp.Service.QualificationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QualificationDTO addQualification(QualificationDTO data) {
        try{
            Qualification qualification = modelMapper.map(data, Qualification.class);
            if(qualification!=null){
                Qualification newQualification=qualificationRepository.save(qualification);
                if(newQualification!=null){
                    return modelMapper.map(newQualification, new TypeToken<QualificationDTO>() {}.getType());
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
