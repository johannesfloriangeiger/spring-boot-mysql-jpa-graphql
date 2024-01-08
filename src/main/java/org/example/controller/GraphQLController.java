package org.example.controller;

import org.example.boundary.CompanyService;
import org.example.boundary.EmployeeService;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {

    private final EmployeeService employeeService;

    private final CompanyService companyService;

    public GraphQLController(final EmployeeService employeeService, final CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @QueryMapping
    public Employee employeeById(@Argument(name = "id") Integer id) {
        return this.employeeService.findById(id)
                .orElseThrow(() -> new NotFoundException(Employee.class, id));
    }

    @QueryMapping
    public Company companyById(@Argument(name = "id") Integer id) {
        return this.companyService.findById(id)
                .orElseThrow(() -> new NotFoundException(Company.class, id));
    }

    @SchemaMapping
    public Company company(final Employee employee) {
        final var company = employee.getCompany();
        final var id = company.getId();

        return this.companyService.findById(id)
                .orElseThrow(() -> new NotFoundException(Company.class, id));
    }
}