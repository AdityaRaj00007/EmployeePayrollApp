package com.tit.employeepayrollapp.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private double salary;
    private String department;
}
