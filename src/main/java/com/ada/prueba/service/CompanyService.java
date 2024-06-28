package com.ada.prueba.service;

import com.ada.prueba.entity.Company;
import com.ada.prueba.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    public List<Company> getDistinctCompanies() {
        return companyRepository.findAll()
                .stream()
                .distinct()
                .toList();
    }

    public List<String> getDistinctCodigoCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(Company::getCodigoCompany)
                .distinct()
                .toList();
    }

    public Optional<Company> getCompanyById(Long id){
        return companyRepository.findById(id);
    }

    public Optional<Company> getCompanyByCodigoCompany(String companyCode){
        return companyRepository.findByCodigoCompany(companyCode);
    }

    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }
}
