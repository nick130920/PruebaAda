CREATE TABLE version_company (
                                 version_company_id bigint PRIMARY KEY AUTO_INCREMENT,
                                 version_company_description VARCHAR(255),
                                 company_id bigint,
                                 version_id bigint,
                                 CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES Company(id_company),
                                 CONSTRAINT fk_version_id FOREIGN KEY (version_id) REFERENCES Version(version_id),
                                 CONSTRAINT uc_version_company UNIQUE (company_id, version_id)
);
