CREATE TABLE person (
	Person_PK varbinary(16) NOT NULL,
	PersonName varchar(25) NOT NULL,
	PersonSurname varchar(25) NOT NULL,
	IdentyNumber varchar(10) NOT NULL,
	
	PRIMARY KEY (Person_PK)
);

CREATE TABLE child (
	Child_PK varbinary(16) NOT NULL,
	Name varchar(25) NOT NULL,
	Surname varchar(25) NOT NULL,
	Person_FK varbinary(16) NOT NULL,
	
	PRIMARY KEY(Child_PK),
	CONSTRAINT FK_Child_Person FOREIGN KEY (Person_FK) REFERENCES person(Person_PK)
);