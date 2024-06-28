package com.ada.prueba.controller;

import com.ada.prueba.dto.CompanyDTO;
import com.ada.prueba.dto.CompanyDetailsDTO;
import com.ada.prueba.dto.VersionDTO;
import com.ada.prueba.entity.Company;
import com.ada.prueba.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies(){
        List<CompanyDTO> companies = companyService.getAllCompanies().stream()
                .map(CompanyDTO::new)
                .toList();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id){
        return companyService.getCompanyById(id)
                .map(company -> ResponseEntity.ok(new CompanyDTO(company)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/details/{companyCode}")
    public ResponseEntity<CompanyDetailsDTO> getCompanyDetailsByCode(@PathVariable String companyCode){
        Optional<Company> company = companyService.getCompanyByCodigoCompany(companyCode);
        return company.map(value -> ResponseEntity.ok(
                new CompanyDetailsDTO(
                        value.getCodigoCompany(),
                        value.getNameCompany(),
                        value.getVersionCompanies().get(0).getVersion().getApplication().getAppName(),
                        new VersionDTO(value.getVersionCompanies().get(0).getVersion())
                ))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return new ResponseEntity<>(companyService.saveCompany(company), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company){
        if (companyService.getCompanyById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        company.setIdCompany(id);
        return new ResponseEntity<>(companyService.saveCompany(company), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id){
        if (companyService.getCompanyById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/distinct")
    public List<Company> getDistinctCompanies() {
        return companyService.getDistinctCompanies();
    }

    @GetMapping("/distinct-codigo-company")
    public List<String> getDistinctCodigoCompanies() {
        return companyService.getDistinctCodigoCompanies();
    }

}
