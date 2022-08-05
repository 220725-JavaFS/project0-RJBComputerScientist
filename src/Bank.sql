-- Create Database if not exists
create database if not exists Bank;

USE Bank;

DROP TABLE IF EXISTS Customer;

-- Create Table
 create table Customer (
	AccountNumber serial not null ,
    Cname varchar(45) default null,
    balance varchar(45) default null,
    pass_code int default null,
    primary key (AccountNumber), -- Auto increments
    unique key Cname_UNIQUE (Cname)
 );
 
DROP TABLE IF EXISTS Administrator;

CREATE TABLE Administrator (
	AdminNumber serial NOT NULL,
	Aname varchar(45) DEFAULT NULL,
	pass_code int DEFAULT NULL,
	PRIMARY KEY (AdminNumber),
	UNIQUE KEY Aname_UNIQUE (Aname)
);

INSERT INTO Administrator (AdminNumber, Cname, pass_code) VALUES 
('ME', 1),
(DEFAULT, 'admin One', 2);