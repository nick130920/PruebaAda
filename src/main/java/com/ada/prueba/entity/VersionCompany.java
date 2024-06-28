package com.ada.prueba.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VersionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_company_id")
    private Long versionCompanyId;

    @Column(name = "version_company_description")
    private String versionCompanyDescription;


    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private Company company;

    @ManyToOne
    @JoinColumn(name = "versionId", nullable = false)
    private Version version;

}
