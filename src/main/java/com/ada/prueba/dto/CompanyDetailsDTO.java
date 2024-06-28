package com.ada.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CompanyDetailsDTO {
    private String codigo_company;
    private String name_company;
    private String app_name;
    private VersionDTO version;
}
