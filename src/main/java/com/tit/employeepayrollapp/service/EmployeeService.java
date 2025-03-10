package com.tit.employeepayrollapp.service;

import com.tit.employeepayrollapp.dto.EmployeeDTO;
import com.tit.employeepayrollapp.entity.Employee;
import com.tit.employeepayrollapp.exception.EmployeeNotFoundException;
import com.tit.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    // Convert Entity to DTO
    private EmployeeDTO convertToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    // Convert DTO to Entity
    private Employee convertToEntity(EmployeeDTO dto) {
        return modelMapper.map(dto, Employee.class);
    }

    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return convertToDTO(employee);
    }

    public ResponseEntity<EmployeeDTO> addEmployee(EmployeeDTO dto) {
        Employee employee = convertToEntity(dto);
        Employee savedEmployee = repository.save(employee);
        return ResponseEntity.ok(convertToDTO(savedEmployee));
    }

    public ResponseEntity<EmployeeDTO> updateEmployee(Long id, EmployeeDTO dto) {
        if (repository.existsById(id)) {
            Employee employee = convertToEntity(dto);
            employee.setId(id); // Preserve existing ID
            Employee updatedEmployee = repository.save(employee);
            return ResponseEntity.ok(convertToDTO(updatedEmployee));
        } else {
            throw new EmployeeNotFoundException(id);
        }
    }

    public ResponseEntity<Void> deleteEmployee(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new EmployeeNotFoundException(id);
        }
    }

    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartment(String department) {
        List<EmployeeDTO> employees = repository.findByDepartment(department)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }
}
