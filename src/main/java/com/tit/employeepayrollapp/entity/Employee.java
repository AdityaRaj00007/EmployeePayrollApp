package com.tit.employeepayrollapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Entity
@Data
@Slf4j
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private double salary;
    private String department;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;


}