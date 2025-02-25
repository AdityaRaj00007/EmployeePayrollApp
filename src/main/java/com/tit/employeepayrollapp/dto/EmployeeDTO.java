package com.tit.employeepayrollapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "Name is required and cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Name must be between 3-50 characters and contain only letters and spaces")
    private String name;
    private double salary;
    private String department;
}
