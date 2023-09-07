package com.example.consultantapp.Repository;

import com.example.consultantapp.Model.ConsultantCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantCountryRepository extends JpaRepository<ConsultantCountry,Integer> {
}
