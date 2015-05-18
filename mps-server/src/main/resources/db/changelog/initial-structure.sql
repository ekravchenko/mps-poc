--liquibase formatted sql

--changeset structure:0
CREATE TABLE entity_status
(
  EntityStatus_PK INT PRIMARY KEY NOT NULL,
  Description     VARCHAR(20)     NOT NULL
);

CREATE TABLE business
(
  Business_PK                  VARBINARY(16) PRIMARY KEY NOT NULL,
  Contact_FK                   VARBINARY(16),
  BusinessType_FK              INT                       NOT NULL,
  EntityStatus_FK              INT,
  BusinessName                 VARCHAR(100)              NOT NULL,
  VatNo                        VARCHAR(12),
  CompanyRegNo                 VARCHAR(40),
  BillingNumber                VARCHAR(13)               NOT NULL,
  CreatedTime                  DATETIME                  NOT NULL,
  UpdatedTime                  DATETIME                  NOT NULL,
  CreatedBy                    VARCHAR(100)              NOT NULL,
  UpdatedBy                    VARCHAR(100)              NOT NULL,
  RowVersion                   INT                       NOT NULL,
  PaymentNotificationProcessID VARCHAR(50),
  SpecialityCode               INT,
  SpecialityDescription        VARCHAR(250)
);

CREATE TABLE business_relation_link
(
  BusinessRelationLink_PK   VARBINARY(16) PRIMARY KEY NOT NULL,
  ParentBusiness_FK         VARBINARY(16)             NOT NULL,
  ChildBusiness_FK          VARBINARY(16)             NOT NULL,
  BusinessRelationStatus_FK INT                       NOT NULL,
  BusinessRelationType_FK   INT                       NOT NULL,
  CreatedTime               DATETIME                  NOT NULL,
  UpdatedTime               DATETIME                  NOT NULL,
  CreatedBy                 VARCHAR(100)              NOT NULL,
  UpdatedBy                 VARCHAR(100)              NOT NULL,
  RowVersion                INT                       NOT NULL
);

CREATE TABLE business_relation_status
(
  BusinessRelationStatus_PK INT PRIMARY KEY NOT NULL,
  BusinessRelationStatus    VARCHAR(20)     NOT NULL
);

CREATE TABLE business_relation_type
(
  BusinessRelationType_PK INT PRIMARY KEY NOT NULL,
  BusinessRelationType    VARCHAR(20)     NOT NULL
);

CREATE TABLE business_type
(
  BusinessType_PK INT PRIMARY KEY NOT NULL,
  Description     VARCHAR(100)    NOT NULL
);

CREATE TABLE contact
(
  Contact_PK VARBINARY(16) PRIMARY KEY NOT NULL
);

CREATE TABLE contact_address
(
  ContactAddress_PK     VARBINARY(16) PRIMARY KEY NOT NULL,
  Contact_FK            VARBINARY(16)             NOT NULL,
  ContactAddressType_FK INT                       NOT NULL,
  Line1                 VARCHAR(100)              NOT NULL,
  Line2                 VARCHAR(100)              NOT NULL,
  Line3                 VARCHAR(100),
  Code                  VARCHAR(10),
  ValidationStatus      INT,
  ValidationDate        DATETIME,
  CreatedTime           DATETIME                  NOT NULL,
  UpdatedTime           DATETIME                  NOT NULL,
  CreatedBy             VARCHAR(100)              NOT NULL,
  UpdatedBy             VARCHAR(100)              NOT NULL,
  RowVersion            INT                       NOT NULL
);

CREATE TABLE contact_address_type
(
  ContactAddressType_PK INT PRIMARY KEY NOT NULL,
  AddressType           VARCHAR(16)     NOT NULL
);

CREATE TABLE contact_email
(
  ContactEmail_PK VARBINARY(16) PRIMARY KEY NOT NULL,
  Contact_FK      VARBINARY(16)             NOT NULL,
  Email           VARCHAR(64)               NOT NULL,
  CreatedTime     DATETIME                  NOT NULL,
  UpdatedTime     DATETIME                  NOT NULL,
  CreatedBy       VARCHAR(100)              NOT NULL,
  UpdatedBy       VARCHAR(100)              NOT NULL,
  RowVersion      INT                       NOT NULL
);

CREATE TABLE contact_telephone
(
  ContactTelephone_PK     VARBINARY(16) PRIMARY KEY NOT NULL,
  Contact_FK              VARBINARY(16)             NOT NULL,
  ContactTelephoneType_FK INT                       NOT NULL,
  Code                    VARCHAR(15),
  Number                  VARCHAR(20)               NOT NULL,
  Prefered                INT                       NOT NULL,
  CreatedTime             DATETIME                  NOT NULL,
  UpdatedTime             DATETIME                  NOT NULL,
  CreatedBy               VARCHAR(100)              NOT NULL,
  UpdatedBy               VARCHAR(100)              NOT NULL,
  RowVersion              INT                       NOT NULL
);

CREATE TABLE contact_telephone_type
(
  ContactTelephoneType_PK INT PRIMARY KEY NOT NULL,
  TelephoneType           VARCHAR(16)     NOT NULL
);

CREATE TABLE person
(
  Person_PK        VARBINARY(16) PRIMARY KEY NOT NULL,
  Gender_FK        INT,
  Title_FK         INT                       NOT NULL,
  Language_FK      INT,
  Contact_FK       VARBINARY(16),
  IdentityNumber   VARCHAR(50),
  Name             VARCHAR(40)               NOT NULL,
  MiddleName       VARCHAR(40),
  Surname          VARCHAR(40)               NOT NULL,
  DateOfBirth      DATETIME,
  CreatedTime      DATETIME                  NOT NULL,
  UpdatedTime      DATETIME                  NOT NULL,
  CreatedBy        VARCHAR(100)              NOT NULL,
  UpdatedBy        VARCHAR(100)              NOT NULL,
  RowVersion       INT                       NOT NULL,
  IdIsPassportFlag SMALLINT                  NOT NULL,
  Country_FK       INT,
  Initials         VARCHAR(10)
);

CREATE TABLE person_gender
(
  Gender_PK INT PRIMARY KEY NOT NULL,
  Gender    VARCHAR(16)     NOT NULL
);

CREATE TABLE person_language
(
  Language_PK INT PRIMARY KEY NOT NULL,
  Launguage   VARCHAR(32)     NOT NULL
);

CREATE TABLE person_title
(
  Title_PK INT PRIMARY KEY NOT NULL,
  Title    VARCHAR(16)     NOT NULL
);

CREATE TABLE country
(
  Country_PK  INT PRIMARY KEY NOT NULL,
  Code        VARCHAR(3)      NOT NULL,
  Description VARCHAR(50)     NOT NULL
);

CREATE TABLE doctor
(
  Doctor_PK             VARBINARY(16) PRIMARY KEY NOT NULL,
  Business_FK           VARBINARY(16)             NOT NULL,
  Person_FK             VARBINARY(16),
  Capacity_FK           INT,
  EntityStatus_FK       INT                       NOT NULL,
  DoctorName            VARCHAR(50)               NOT NULL,
  PracticeNumber        VARCHAR(20),
  HPCNumber             VARCHAR(50),
  Qualification         VARCHAR(255),
  CreatedTime           DATETIME                  NOT NULL,
  UpdatedTime           DATETIME                  NOT NULL,
  CreatedBy             VARCHAR(100)              NOT NULL,
  UpdatedBy             VARCHAR(100)              NOT NULL,
  RowVersion            INT                       NOT NULL,
  SpecialityCode        INT,
  SpecialityDescription VARCHAR(250)
);

CREATE TABLE doctor_network
(
  DoctorNetwork_PK  VARBINARY(16) PRIMARY KEY NOT NULL,
  Doctor_FK         VARBINARY(16)             NOT NULL,
  DateFrom          DATETIME                  NOT NULL,
  DateTo            DATETIME,
  CreatedTime       DATETIME                  NOT NULL,
  UpdatedTime       DATETIME                  NOT NULL,
  CreatedBy         VARCHAR(100)              NOT NULL,
  UpdatedBy         VARCHAR(100)              NOT NULL,
  RowVersion        INT                       NOT NULL,
  EntityStatus_FK   INT DEFAULT ((1))         NOT NULL,
  SchemeDescription VARCHAR(128)              NOT NULL
);

CREATE TABLE capacity
(
  Capacity_PK INT PRIMARY KEY NOT NULL,
  Description VARCHAR(50)     NOT NULL
);

ALTER TABLE business ADD CONSTRAINT FK_business__entity_status FOREIGN KEY (EntityStatus_FK) REFERENCES entity_status (EntityStatus_PK);
ALTER TABLE business ADD CONSTRAINT FK_business__business_type FOREIGN KEY (BusinessType_FK) REFERENCES business_type (BusinessType_PK);
ALTER TABLE business ADD CONSTRAINT FK_business__contract FOREIGN KEY (Contact_FK) REFERENCES contact (Contact_PK);
ALTER TABLE business_relation_link ADD CONSTRAINT FK_business_relation_link__child_business FOREIGN KEY (ChildBusiness_FK) REFERENCES business (Business_PK);
ALTER TABLE business_relation_link ADD CONSTRAINT FK_business_relation_link__parent_business FOREIGN KEY (ParentBusiness_FK) REFERENCES business (Business_PK);
ALTER TABLE business_relation_link ADD CONSTRAINT FK_business_relation_link__business_relation_status FOREIGN KEY (BusinessRelationStatus_FK) REFERENCES business_relation_status (BusinessRelationStatus_PK);
ALTER TABLE business_relation_link ADD CONSTRAINT FK_business_relation_link__business_relation_type FOREIGN KEY (BusinessRelationType_FK) REFERENCES business_relation_type (BusinessRelationType_PK);
ALTER TABLE contact_address ADD CONSTRAINT FK_contact_address__contact FOREIGN KEY (Contact_FK) REFERENCES contact (Contact_PK);
ALTER TABLE contact_address ADD CONSTRAINT FK_contact_address__contact_address_type FOREIGN KEY (ContactAddressType_FK) REFERENCES contact_address_type (ContactAddressType_PK);
ALTER TABLE contact_email ADD CONSTRAINT FK_contact_email__contact FOREIGN KEY (Contact_FK) REFERENCES contact (Contact_PK);
ALTER TABLE contact_telephone ADD CONSTRAINT FK_contact_telephone__contact FOREIGN KEY (Contact_FK) REFERENCES contact (Contact_PK);
ALTER TABLE contact_telephone ADD CONSTRAINT FK_contact_telephone__contact_telephone_type FOREIGN KEY (ContactTelephoneType_FK) REFERENCES contact_telephone_type (ContactTelephoneType_PK);
ALTER TABLE person ADD CONSTRAINT FK_person__contact FOREIGN KEY (Contact_FK) REFERENCES contact (Contact_PK);
ALTER TABLE person ADD CONSTRAINT FK_person__country FOREIGN KEY (Country_FK) REFERENCES country (Country_PK);
ALTER TABLE person ADD CONSTRAINT FK_person__person_gender FOREIGN KEY (Gender_FK) REFERENCES person_gender (Gender_PK);
ALTER TABLE person ADD CONSTRAINT FK_person__person_language FOREIGN KEY (Language_FK) REFERENCES person_language (Language_PK);
ALTER TABLE person ADD CONSTRAINT FK_person__person_title FOREIGN KEY (Title_FK) REFERENCES person_title (Title_PK);
ALTER TABLE doctor ADD CONSTRAINT FK_doctor__business FOREIGN KEY (Business_FK) REFERENCES business (Business_PK);
ALTER TABLE doctor ADD CONSTRAINT FK_doctor__capacity FOREIGN KEY (Capacity_FK) REFERENCES capacity (Capacity_PK);
ALTER TABLE doctor ADD CONSTRAINT FK_doctor__entity_status FOREIGN KEY (EntityStatus_FK) REFERENCES entity_status (EntityStatus_PK);
ALTER TABLE doctor ADD CONSTRAINT FK_doctor__person FOREIGN KEY (Person_FK) REFERENCES person (Person_PK);
ALTER TABLE doctor_network ADD CONSTRAINT FK_doctor_network__doctor FOREIGN KEY (Doctor_FK) REFERENCES doctor (Doctor_PK);
ALTER TABLE doctor_network ADD CONSTRAINT FK_doctor_network__entity_status FOREIGN KEY (EntityStatus_FK) REFERENCES entity_status (EntityStatus_PK);
