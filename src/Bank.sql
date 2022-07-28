-- Create Database if not exists
create database if not exists Bank;

USE Bank;

-- Create Table
 create table `Customer` (
	`AccountNumber` int not null auto_increment,
    `Cname` varchar(45) default null,
    `balance` varchar(45) default null,
    `pass_code` int default null,
    primary key (`AccountNumber`), -- Auto increments
    unique key `Cname_UNIQUE` (`Cname`)
 );