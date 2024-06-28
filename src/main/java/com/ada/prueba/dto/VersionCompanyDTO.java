package com.ada.prueba.dto;

import com.ada.prueba.entity.VersionCompany;
import lombok.Data;
import org.modelmapper.ModelMapper;


@Data
public class VersionCompanyDTO {
    private Long versionCompanyId;
    private String versionCompanyDescription;
    private VersionDTO versionDTO;

    public VersionCompanyDTO(VersionCompany versionCompany) {
        this.versionCompanyId = versionCompany.getVersionCompanyId();
        this.versionCompanyDescription = versionCompany.getVersionCompanyDescription();
        ModelMapper modelMapper = new ModelMapper();
        this.versionDTO = modelMapper.map(versionCompany.getVersion(), VersionDTO.class);
    }
}
