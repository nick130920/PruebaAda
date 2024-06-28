package com.ada.prueba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Long idCompany;

    @Column(name = "codigo_company", unique = true)
    private String codigoCompany;

    @Column(name = "name_company")
    private String nameCompany;

    @Column(name = "description_company")
    private String descriptionCompany;


    @OneToMany( cascade = CascadeType.ALL, mappedBy = "company")
    private List<VersionCompany> versionCompanies;


}
