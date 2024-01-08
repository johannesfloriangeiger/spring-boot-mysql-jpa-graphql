package org.example.boundary;

import org.example.control.EmployeeRepository;
import org.example.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findById(final Integer id) {
        return this.employeeRepository.findById(id);
    }
}