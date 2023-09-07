package com.example.consultantapp.Repository;

import com.example.consultantapp.Model.AvailableTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableTimesRepository extends JpaRepository<AvailableTimes,Integer> {
    @Query(value = "SELECT * FROM consultantapp.available_times WHERE consultant_id = ?1 AND available_time_id NOT IN " +
            "(SELECT available_time_id FROM consultantapp.appointment WHERE appointment_status = 1)", nativeQuery = true)
    List<AvailableTimes> getAvailableTimesByConsultantId(int consultantId);
}
