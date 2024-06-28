package com.ada.prueba.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TMP_LLENAR_CAMPOS")
public class TmpLlenarCampos {
    @Id
    private Long  idCompany;

    private String codigoCompany ;
    private String nameCompany ;
    private String descriptionCompany ;
    private Long versionId ;
    private Long appId;
    private String version ;
    private String versionDescription ;
    private Long versionCompanyId ;
    private Long companyId ;
    private String versionCompanyDescription ;
    private String appCode ;
    private String appName ;
    private String appDescription;
}
