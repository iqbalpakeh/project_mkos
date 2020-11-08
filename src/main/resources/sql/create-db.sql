-- set global time_zone = '+8:00';

-- create database db_mkos;

use db_mkos;

create table expense(
	id int primary key auto_increment,
    expense_type varchar(100),
    expense_information varchar(100)
);

create table expense_payment(
	id int primary key auto_increment,
    payment_timestamp int,
    payment_amount int,
    payment_information varchar(100),
    expense_type varchar(100),
    expense_information varchar(100)
);

create table income_payment(
	id int primary key auto_increment,
    payment_timestamp int,
    payment_amount int,
    payment_information varchar(100),
    room_number varchar(100),
    room_rate varchar(100),
    room_information varchar(100),
	tenant_name varchar(100),
    tenant_phone varchar(100)
);

create table tenant(
	id int primary key auto_increment,
    tenant_name varchar(100),
    tenant_phone varchar(100)
);

create table room(
	id int primary key auto_increment,
    room_number varchar(100),
    room_rate int,
    room_information varchar(100),
    tenant_id int,
    foreign key (tenant_id) references Tenant(id)
);

create table tenant_log(
	id int primary key auto_increment,
	checkin int,
    checkout int,
    tenant_name varchar(100),
    tenant_phone varchar(100),
    room_number varchar(100)
);

select * from expense;

select * from expense_payment;

select * from income_payment;

select * from room;

select * from tenant;

select * from tenant_log;