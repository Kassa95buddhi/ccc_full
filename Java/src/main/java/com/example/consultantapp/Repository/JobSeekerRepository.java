package com.example.consultantapp.Repository;

import com.example.consultantapp.Model.JobSeeker;
import com.example.consultantapp.Model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker,Integer> {
    @Query(value = "SELECT * FROM consultantapp.job_seeker WHERE user_id = ?1", nativeQuery = true)
    JobSeeker getJobSeekerByUserId(int userId);
}
