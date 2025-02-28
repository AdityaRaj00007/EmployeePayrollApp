package com.tit.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@ToString
public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "Name is required and cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Name must be between 3-50 characters and contain only letters and spaces")
    private String name;
    @Min(value = 500 , message = "Min Wage should be more than 500")
    private double salary;
    @NotNull(message = "department should not be empty")
    private String department;
    @Pattern(regexp = "male|female" , message = "Gender needs to be male or female")
    private String gender;
    @JsonFormat(pattern="dd MMM yyyy")
    @NotNull(message = "startDate should Not be Empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    private LocalDate startDate;
    @NotBlank(message = "Note cannot be empty")
    private String note;
    @NotBlank(message = "profilePic cannot be empty")
    private String profilePic;
}
