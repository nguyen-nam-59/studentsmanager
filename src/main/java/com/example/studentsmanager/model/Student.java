package com.example.studentsmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentid;
    private String name;
    private String email;
    private int age;
    private LocalDate birth;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    }
