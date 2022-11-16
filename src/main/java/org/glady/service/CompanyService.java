package org.glady.service;

import org.glady.dao.Company;
import org.glady.dto.CompanyDto;
import org.glady.repository.CompanyRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getCompanyById(Integer id) {
        return companyRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Company not found!"));
    }

    @Transactional
    public void persistCompany(Company company) {
        companyRepository.persist(company);
    }

    @Transactional
    public void persistCompanyFromDto(CompanyDto companyDto) {
        companyRepository.persist(
                new Company(
                        companyDto.getName(),
                        companyDto.getBalance()));
    }
}
