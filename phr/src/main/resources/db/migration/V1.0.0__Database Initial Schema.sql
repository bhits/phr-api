CREATE TABLE address_use_code (
  id               BIGINT AUTO_INCREMENT NOT NULL,
  code             VARCHAR(250)          NOT NULL,
  code_system      VARCHAR(250)          NULL,
  code_system_name VARCHAR(250)          NOT NULL,
  display_name     VARCHAR(250)          NOT NULL,
  originalText     VARCHAR(250)          NULL,
  version          INT                   NULL,
  CONSTRAINT PK_ADDRESS_USE_CODE PRIMARY KEY (id)
);

CREATE TABLE administrative_gender_code (
  id               BIGINT AUTO_INCREMENT NOT NULL,
  code             VARCHAR(250)          NOT NULL,
  code_system      VARCHAR(250)          NULL,
  code_system_name VARCHAR(250)          NOT NULL,
  display_name     VARCHAR(250)          NOT NULL,
  originalText     VARCHAR(250)          NULL,
  version          INT                   NULL,
  CONSTRAINT PK_ADMINISTRATIVE_GENDER_CODE PRIMARY KEY (id)
);

CREATE TABLE country_code (
  id               BIGINT AUTO_INCREMENT NOT NULL,
  code             VARCHAR(250)          NOT NULL,
  code_system      VARCHAR(250)          NULL,
  code_system_name VARCHAR(250)          NOT NULL,
  display_name     VARCHAR(250)          NOT NULL,
  originalText     VARCHAR(250)          NULL,
  version          INT                   NULL,
  CONSTRAINT PK_COUNTRY_CODE PRIMARY KEY (id)
);

CREATE TABLE patient (
  id                       BIGINT AUTO_INCREMENT NOT NULL,
  city                     VARCHAR(255)          NULL,
  postal_code              VARCHAR(255)          NULL,
  street_address_line      VARCHAR(255)          NULL,
  birth_day                DATETIME              NULL,
  email                    VARCHAR(255)          NULL,
  first_name               VARCHAR(30)           NOT NULL,
  last_name                VARCHAR(30)           NOT NULL,
  socialSecurityNumber     VARCHAR(255)          NULL,
  telephone                VARCHAR(255)          NULL,
  username                 VARCHAR(255)           NULL,
  addressUseCode           BIGINT                NULL,
  countryCode              BIGINT                NULL,
  stateCode                BIGINT                NULL,
  administrativeGenderCode BIGINT                NULL,
  telecomUseCode           BIGINT                NULL,
  medical_record_number varchar(30)              NULL,
  enterprise_identifier varchar(255)             NULL,
  resource_identifier varchar(255)               NULL,
  CONSTRAINT PK_PATIENT PRIMARY KEY (id)
);

CREATE TABLE patient_audit (
  id                       BIGINT       NOT NULL,
  REV                      INT          NOT NULL,
  REVTYPE                  TINYINT      NULL,
  city                     VARCHAR(255) NULL,
  postal_code              VARCHAR(255) NULL,
  street_address_line      VARCHAR(255) NULL,
  birth_day                DATETIME     NULL,
  email                    VARCHAR(255) NULL,
  first_name               VARCHAR(30)  NULL,
  last_name                VARCHAR(30)  NULL,
  socialSecurityNumber     VARCHAR(255) NULL,
  telephone                VARCHAR(255) NULL,
  username                 VARCHAR(255)  NULL,
  addressUseCode           BIGINT       NULL,
  countryCode              BIGINT       NULL,
  stateCode                BIGINT       NULL,
  administrativeGenderCode BIGINT       NULL,
  telecomUseCode           BIGINT       NULL,
  medical_record_number varchar(30)     NULL,
  enterprise_identifier varchar(255)    NULL,
  resource_identifier varchar(255)      NULL
);

CREATE TABLE revinfo (
  REV      INT AUTO_INCREMENT NOT NULL,
  REVTSTMP BIGINT             NULL,
  CONSTRAINT PK_REVINFO PRIMARY KEY (REV)
);

CREATE TABLE state_code (
  id               BIGINT AUTO_INCREMENT NOT NULL,
  code             VARCHAR(250)          NOT NULL,
  code_system      VARCHAR(250)          NULL,
  code_system_name VARCHAR(250)          NOT NULL,
  display_name     VARCHAR(250)          NOT NULL,
  originalText     VARCHAR(250)          NULL,
  version          INT                   NULL,
  CONSTRAINT PK_STATE_CODE PRIMARY KEY (id)
);

CREATE TABLE telecom_use_code (
  id               BIGINT AUTO_INCREMENT NOT NULL,
  code             VARCHAR(250)          NOT NULL,
  code_system      VARCHAR(250)          NULL,
  code_system_name VARCHAR(250)          NOT NULL,
  display_name     VARCHAR(250)          NOT NULL,
  originalText     VARCHAR(250)          NULL,
  version          INT                   NULL,
  CONSTRAINT PK_TELECOM_USE_CODE PRIMARY KEY (id)
);

ALTER TABLE patient_audit ADD PRIMARY KEY (id, REV);

ALTER TABLE patient ADD CONSTRAINT FK_8sfvh85lrg919dnvj9iqhh986 FOREIGN KEY (administrativeGenderCode) REFERENCES administrative_gender_code (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE patient_audit ADD CONSTRAINT FK_ahxtfw2b36s4wuro530bvkxro FOREIGN KEY (REV) REFERENCES revinfo (REV)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE patient ADD CONSTRAINT FK_fmxslsh56nc572uxg7oifk0ib FOREIGN KEY (stateCode) REFERENCES state_code (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE patient ADD CONSTRAINT FK_lbh8hbceyrre0pfipl92ii1wt FOREIGN KEY (addressUseCode) REFERENCES address_use_code (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE patient ADD CONSTRAINT FK_n25syp9n9i4ywios3imhyf1ga FOREIGN KEY (telecomUseCode) REFERENCES telecom_use_code (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;