--liquibase formatted sql

--changeset data:0
INSERT INTO entity_status (EntityStatus_PK, Description) VALUES (1, 'Active'), (2, 'Inactive');

INSERT INTO business_relation_status (BusinessRelationStatus_PK, BusinessRelationStatus)
VALUES (1, 'Active'), (2, 'Cancelled'), (3, 'Suspended');

INSERT INTO business_relation_type (BusinessRelationType_PK, BusinessRelationType) VALUES (1, 'Bureau');

INSERT INTO business_type (BusinessType_PK, Description)
VALUES (1, 'Bureau'), (2, 'Multibranch'), (3, 'Single doctor practice'), (4, 'Group practice'),
  (5, 'Partnership practice'), (6, 'Radiologist'), (7, 'Channel');

INSERT INTO contact_address_type (ContactAddressType_PK, AddressType) VALUES (1, 'Postal'), (2, 'Physical');

INSERT INTO contact_telephone_type (ContactTelephoneType_PK, TelephoneType)
VALUES (1, 'Office'), (2, 'Home'), (3, 'Mobile'), (4, 'Fax');

INSERT INTO person_gender (Gender_PK, Gender) VALUES (1, 'Male'), (2, 'Female'), (99, 'Unknow');

INSERT INTO person_language (Language_PK, Launguage) VALUES (1, 'English');

INSERT INTO person_title (Title_PK, Title)
VALUES (1, 'Dr'), (2, 'Miss'), (3, 'Mr'), (4, 'Mrs'), (5, 'Ms'), (6, 'Prof'), (7, 'Sir'), (8, 'Sister'), (99, 'Unknow');

INSERT INTO country (Country_PK, Code, Description) VALUES (233, 'UA', 'Ukraine');

INSERT INTO capacity (Capacity_PK, Description) VALUES (1, 'Treating'), (2, 'Assisting'), (3, 'Referring');

