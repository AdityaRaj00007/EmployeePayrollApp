package com.tit.employeepayrollapp.controller;

import com.tit.employeepayrollapp.dto.EmployeeDTO;
import com.tit.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return service.addEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        return service.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        return service.deleteEmployee(id);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartment(@PathVariable String department) {
        return service.getEmployeesByDepartment(department);
    }
}
