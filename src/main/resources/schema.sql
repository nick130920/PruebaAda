CREATE TABLE TMP_LLENAR_CAMPOS (
    id_company bigint ,
    codigo_company VARCHAR(255),
   name_company VARCHAR(255),
   description_company VARCHAR(255),
   version_id bigint,
   app_id bigint,
   version VARCHAR(255),
   version_description VARCHAR(255),
   version_company_id bigint,
   company_id bigint,
   version_company_description VARCHAR(255),
   app_code VARCHAR(255),
   app_name VARCHAR(255),
   app_description VARCHAR(255)
);

INSERT INTO TMP_LLENAR_CAMPOS
(id_company, codigo_company, name_company, description_company, version_id, app_id, version, version_description, version_company_id, company_id, version_company_description, app_code, app_name, app_description)
VALUES
    (1, 'C01', 'Company one', 'description', 1, 1, '1.0', 'description version one', 1, 1, 'description version company one', 'App01', 'Application one', 'App description'),
    (2, 'C02', 'Company two', 'description', 2, 2, '2.0', 'description version two', 2, 2, 'description version company two', 'App02', 'Application two', 'App description');


/*
CREATE PROCEDURE InsertarDatosDesdeCursor()
BEGIN
    DECLARE done BOOLEAN DEFAULT FALSE;
DECLARE idCompanyTemp BIGINT;
DECLARE codigoCompanyTemp VARCHAR(255);
DECLARE nameCompanyTemp VARCHAR(255);
DECLARE descriptionCompanyTemp VARCHAR(255);
DECLARE versionIdTemp BIGINT;
DECLARE appIdTemp BIGINT;
DECLARE versionTemp VARCHAR(255);
DECLARE versionDescriptionTemp VARCHAR(255);
DECLARE versionCompanyIdTemp BIGINT;
DECLARE company_idTemp BIGINT;
DECLARE versionCompanyDescriptionTemp VARCHAR(255);
DECLARE appCodeTemp VARCHAR(255);
DECLARE appNameTemp VARCHAR(255);
DECLARE appDescriptionTemp VARCHAR(255);

DECLARE CTemporal CURSOR FOR
SELECT id_company, codigo_company, name_company, description_company,
       version_id, app_id, version, version_description,
       version_company_id, company_id, version_company_description,
       app_code, app_name, app_description
FROM TMP_LLENAR_CAMPOS;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

OPEN CTemporal;

insert_loop: LOOP
        FETCH CTemporal INTO idCompanyTemp, codigoCompanyTemp, nameCompanyTemp, descriptionCompanyTemp,
                            versionIdTemp, appIdTemp, versionTemp, versionDescriptionTemp,
                            versionCompanyIdTemp, company_idTemp, versionCompanyDescriptionTemp,
                            appCodeTemp, appNameTemp, appDescriptionTemp;

IF done THEN
            LEAVE insert_loop;
END IF;

        -- Insertar en Company
INSERT INTO Company (id_company, codigo_company, name_company, description_company)
VALUES (idCompanyTemp, codigoCompanyTemp, nameCompanyTemp, descriptionCompanyTemp);

-- Insertar en Version
INSERT INTO Version (version_id, version, version_description, app_id)
VALUES (versionIdTemp, versionTemp, versionDescriptionTemp, appIdTemp);

-- Insertar en Application
INSERT INTO Application (app_id, app_code, app_name, app_description)
VALUES (appIdTemp, appCodeTemp, appNameTemp, appDescriptionTemp);

-- Insertar en VersionCompany
INSERT INTO VersionCompany (version_company_id, version_company_description, company_id, version_id)
VALUES (versionCompanyIdTemp, versionCompanyDescriptionTemp, idCompanyTemp, versionIdTemp);
END LOOP;

CLOSE CTemporal;
END;
*/
