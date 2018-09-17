CREATE TABLE Person (
	PersonID serial NOT NULL,
	FirstName varchar(30) NOT NULL,
	MiddleName varchar(30),
	LastName varchar(30) NOT NULL,
	Sex varchar,
	NationalNo varchar(11) NOT NULL,
	DOB DATE,
	PlaceOfBrith varchar,
	CellPhone varchar(20),
	Email varchar(50),
	InsertDate TIMESTAMP,
	InsertingPerson integer,
	LastModDate TIMESTAMP,
	LastModPerson integer,
	CONSTRAINT Person_pk PRIMARY KEY (PersonID)
) WITH (
  OIDS=FALSE
);



CREATE TABLE Address (
	AddressID serial NOT NULL,
	AddressTypeID integer NOT NULL,
	Street varchar(30),
	HomeNo integer,
	FlattNo integer,
	Voivodship varchar,
	District varchar,
	Place varchar(30),
	PostalCode varchar(9),
	PostOffice varchar(30),
	Country varchar,
	Active BOOLEAN,
	InsertDate TIMESTAMP,
	InsertingPerson integer,
	LastModDate TIMESTAMP,
	LastModPerson integer,
	CONSTRAINT Address_pk PRIMARY KEY (AddressID)
) WITH (
  OIDS=FALSE
);



CREATE TABLE LAddressPerson (
	LAddressPerson serial NOT NULL,
	AddressID integer NOT NULL,
	PersonID integer NOT NULL,
	InsertDate TIMESTAMP,
	InsertingPerson integer,
	LastModDate TIMESTAMP,
	LastModPerson integer,
	CONSTRAINT LAddressPerson_pk PRIMARY KEY (LAddressPerson)
) WITH (
  OIDS=FALSE
);



CREATE TABLE Employee (
	EmployeeID serial NOT NULL,
	PersonID integer NOT NULL,
	Active BOOLEAN,
	InsertDate TIMESTAMP,
	InsertingPerson integer,
	LastModDate TIMESTAMP,
	LastModPerson integer,
	CONSTRAINT Employee_pk PRIMARY KEY (EmployeeID)
) WITH (
  OIDS=FALSE
);



ALTER TABLE Person ADD CONSTRAINT Person_fk0 FOREIGN KEY (InsertingPerson) REFERENCES Person(PersonID);
ALTER TABLE Person ADD CONSTRAINT Person_fk1 FOREIGN KEY (LastModPerson) REFERENCES Person(PersonID);

ALTER TABLE Address ADD CONSTRAINT Address_fk0 FOREIGN KEY (InsertingPerson) REFERENCES Person(PersonID);
ALTER TABLE Address ADD CONSTRAINT Address_fk1 FOREIGN KEY (LastModPerson) REFERENCES Person(PersonID);

ALTER TABLE LAddressPerson ADD CONSTRAINT LAddressPerson_fk0 FOREIGN KEY (AddressID) REFERENCES Address(AddressID);
ALTER TABLE LAddressPerson ADD CONSTRAINT LAddressPerson_fk1 FOREIGN KEY (PersonID) REFERENCES Person(PersonID);
ALTER TABLE LAddressPerson ADD CONSTRAINT LAddressPerson_fk2 FOREIGN KEY (InsertingPerson) REFERENCES Person(PersonID);
ALTER TABLE LAddressPerson ADD CONSTRAINT LAddressPerson_fk3 FOREIGN KEY (LastModPerson) REFERENCES Person(PersonID);

ALTER TABLE Employee ADD CONSTRAINT Employee_fk0 FOREIGN KEY (PersonID) REFERENCES Person(PersonID);
ALTER TABLE Employee ADD CONSTRAINT Employee_fk1 FOREIGN KEY (InsertingPerson) REFERENCES Person(PersonID);
ALTER TABLE Employee ADD CONSTRAINT Employee_fk2 FOREIGN KEY (LastModPerson) REFERENCES Person(PersonID);

