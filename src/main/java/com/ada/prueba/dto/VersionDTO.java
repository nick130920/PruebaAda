package com.ada.prueba.dto;

import com.ada.prueba.entity.Application;
import com.ada.prueba.entity.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersionDTO {
    private Long versionId;
    private String version;
    private String versionDescription;
    private Application application;

    public VersionDTO(VersionDTO versionDTO) {
        this.versionId = versionDTO.getVersionId();
        this.version = versionDTO.getVersion();
        this.versionDescription = versionDTO.getVersionDescription();
        this.application = versionDTO.getApplication();
    }

    public VersionDTO(Version version) {
        this.versionId = version.getVersionId();
        this.version = version.getVersion();
        this.versionDescription = version.getVersionDescription();
        this.application = version.getApplication();
    }
}
