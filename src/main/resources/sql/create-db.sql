-- set global time_zone = '+8:00';

-- create database db_mkos;

use db_mkos;

create table Expense(
	id int primary key auto_increment,
    expense_type varchar(20),
    expense_information varchar(20)
);

create table ExpensePayment(
	id int primary key auto_increment,
    payment_timestamp int,
    payment_amount int,
    payment_information varchar(20),
    expense_type varchar(20),
    expense_information varchar(20)
);

create table IncomePayment(
	id int primary key auto_increment,
    payment_timestamp int,
    payment_amount int,
    payment_information varchar(20),
    room_number varchar(20),
    room_rate varchar(20),
    room_information varchar(20),
	tenant_name varchar(20),
    tenant_phone varchar(20)
);

create table Tenant(
	id int primary key auto_increment,
    tenant_name varchar(20),
    tenant_phone varchar(20)
);

create table Room(
	id int primary key auto_increment,
    room_number varchar(20),
    room_rate int,
    room_information varchar(20),
    tenant_id int,
    foreign key (tenant_id) references Tenant(id)
);

create table TenantLog(
	id int primary key auto_increment,
	checkin int,
    checkout int,
    tenant_name varchar(20),
    tenant_phone varchar(20),
    room_number varchar(20)
);

select * from Expense;

select * from ExpensePayment;

select * from IncomePayment;

select * from Room;

select * from Tenant;

select * from TenantLog;