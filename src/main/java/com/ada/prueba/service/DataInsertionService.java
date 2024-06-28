package com.ada.prueba.service;

import com.ada.prueba.entity.TmpLlenarCampos;
import com.ada.prueba.entity.Application;
import com.ada.prueba.entity.Company;
import com.ada.prueba.entity.Version;
import com.ada.prueba.entity.VersionCompany;
import com.ada.prueba.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DataInsertionService {

    private CompanyRepository companyRepository;
    private ApplicationRepository applicationRepository;
    private VersionCompanyRepository versionCompanyRepository;
    private VersionRepository versionRepository;
    private TmpRepository tmpRepository;


    @Transactional
    public void insertData(){
        List<TmpLlenarCampos> tmpData = tmpRepository.findAll();

        for (TmpLlenarCampos tmp : tmpData) {

            Application application = Application.builder()
                    .appId(tmp.getAppId())
                    .appCode(tmp.getAppCode())
                    .appName(tmp.getAppName())
                    .appDescription(tmp.getAppDescription())
                    .build();
            applicationRepository.save(application);

            Version version = Version.builder()
                    .versionId(tmp.getVersionId())
                    .version(tmp.getVersion())
                    .versionDescription(tmp.getVersionDescription())
                    .application(application)
                    .build();
            versionRepository.save(version);

            Company company = Company.builder()
                    .idCompany(tmp.getIdCompany())
                    .codigoCompany(tmp.getCodigoCompany())
                    .nameCompany(tmp.getNameCompany())
                    .descriptionCompany(tmp.getDescriptionCompany())
                    .build();
            companyRepository.save(company);

            VersionCompany versionCompany = VersionCompany.builder()
                    .versionCompanyId(tmp.getVersionCompanyId())
                    .versionCompanyDescription(tmp.getVersionCompanyDescription())
                    .company(company)
                    .version(version)
                    .build();
            versionCompanyRepository.save(versionCompany);

        }


    }
}
