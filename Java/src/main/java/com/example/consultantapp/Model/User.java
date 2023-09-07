package com.example.consultantapp.Model;

import com.example.consultantapp.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    private int mobile;
    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private Role role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private LoginDetails loginDetails;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private JobSeeker jobSeeker;
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Consultant consultant;
}
