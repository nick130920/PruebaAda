package com.ada.prueba.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_id")
    private Long versionId;

    @Column(name = "version")
    private String version;

    @Column(name = "version_description")
    private String versionDescription;

    @ManyToOne
    @JoinColumn(name = "app_id", referencedColumnName = "appId")
    private Application application;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "version")
    private List<VersionCompany> versionCompanies;

}
