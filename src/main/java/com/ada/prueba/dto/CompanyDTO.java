package com.ada.prueba.dto;

import com.ada.prueba.entity.Company;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CompanyDTO {
    private Long idCompany;
    private String codigoCompany;
    private String nameCompany;
    private String descriptionCompany;
    private List<VersionCompanyDTO> versionCompanies;

    public CompanyDTO(Company company) {
        this.idCompany = company.getIdCompany();
        this.codigoCompany = company.getCodigoCompany();
        this.nameCompany = company.getNameCompany();
        this.descriptionCompany = company.getDescriptionCompany();
        this.versionCompanies = company.getVersionCompanies().stream()
                .map(VersionCompanyDTO::new)
                .toList();
    }
}
