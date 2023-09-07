package com.example.consultantapp.Repository;

import com.example.consultantapp.Model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant,Integer> {
    @Query(value = "SELECT * FROM consultantapp.consultant WHERE user_id = ?1", nativeQuery = true)
    Consultant getConsultantByUserId(int userId);
}
