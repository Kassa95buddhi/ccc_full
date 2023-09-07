package com.example.consultantapp.Repository;

import com.example.consultantapp.Model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails,Integer> {
    @Query(value = "SELECT * FROM consultantapp.login_details WHERE email = ?1", nativeQuery = true)
    LoginDetails validateEmail(String email);
    @Query(value = "SELECT * FROM consultantapp.login_details WHERE email = ?1 AND password=?2", nativeQuery = true)
    LoginDetails getLoginData(String email, String password);
}
