DROP TABLE IF EXISTS customer;

-- Create Table
 create table customer (
	AccountNumber serial not null ,
    Cname varchar(45) default null UNIQUE,
    balance integer CHECK(balance > 0) default null,
    pass_code int default null
 );

alter table customer add constraint pk_cu primary key (AccountNumber, Cname);
 
DROP TABLE IF EXISTS administrator;

CREATE TABLE administrator (
	AdminNumber serial NOT NULL,
	Aname varchar(45) DEFAULT null unique,
	pass_code int DEFAULT null
);

alter table administrator add constraint pk_ad primary key (AdminNumber, Aname);

INSERT INTO administrator (AdminNumber, Aname, pass_code) VALUES 
(default, 'ME', 1),
(DEFAULT, 'admin One', 2);

-- FOR TESTING AND CLONED DATABASE STRUCTURE
INSERT INTO customer  (AccountNumber, Cname, balance, pass_code) VALUES 
(default, 'Customer 1', 10, 100),
(DEFAULT, 'Customer 2', 20, 101);