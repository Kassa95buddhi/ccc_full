package com.example.consultantapp.Repository;

import com.example.consultantapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    long deleteByUserIdEquals(int userId);
}
