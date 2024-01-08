package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "companies")
@Data
public class Company {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;
}