package org.example.boundary;

import org.example.control.CompanyRepository;
import org.example.entity.Company;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(final CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> findById(final Integer id) {
        return this.companyRepository.findById(id);
    }
}