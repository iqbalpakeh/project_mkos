set global time_zone = '+8:00';

create database db_mkos;

use db_mkos;

create table Expense(
	id int primary key auto_increment,
    variant varchar(20),
    information varchar(20)
);

create table ExpensePayment(
	id int primary key auto_increment,
    timestamped int,
    amount int,
    variant varchar(20),
    information varchar(20)
);

create table IncomePayment(
	id int primary key auto_increment,
    timestamped int,
    amount int,
    roomNumber varchar(20),
    tenantName varchar(20),
    information varchar(20)
);

create table Room(
	id int primary key auto_increment,
    roomNumber varchar(20),
    roomRate int,
    information varchar(20),
    tenant_id int,
    foreign key (tenant_id) references Tenant(id)
);

create table Tenant(
	id int primary key auto_increment,
    tenantName varchar(20),
    tenantPhone varchar(20)
);

create table TenantLog(
	id int primary key auto_increment,
    tenantName varchar(20),
    tenantPhone varchar(20),
    roomNumber varchar(20),
    checkin int,
    checkout int
);
