-- set global time_zone = '+8:00';

-- create database db_mkos;

use db_mkos;

create table Expense(
	id int primary key auto_increment,
    expenseType varchar(20),
    expenseInformation varchar(20)
);

create table ExpensePayment(
	id int primary key auto_increment,
    paymentTimestamp int,
    paymentAmount int,
    paymentInformation varchar(20),
    expenseType varchar(20),
    expenseInformation varchar(20)
);

create table IncomePayment(
	id int primary key auto_increment,
    paymentTimestamp int,
    paymentAmount int,
    paymentInformation varchar(20),
    roomNumber varchar(20),
    roomRate varchar(20),
    roomInformation varchar(20),
	tenantName varchar(20),
    tenantPhone varchar(20)
);

create table Tenant(
	id int primary key auto_increment,
    tenantName varchar(20),
    tenantPhone varchar(20)
);

create table Room(
	id int primary key auto_increment,
    roomNumber varchar(20),
    roomRate int,
    roomInformation varchar(20),
    tenant_id int,
    foreign key (tenant_id) references Tenant(id)
);

create table TenantLog(
	id int primary key auto_increment,
	checkin int,
    checkout int,
    tenantName varchar(20),
    tenantPhone varchar(20),
    roomNumber varchar(20)
);

select * from Expense;

select * from ExpensePayment;

select * from IncomePayment;

select * from Room;

select * from Tenant;

select * from TenantLog;