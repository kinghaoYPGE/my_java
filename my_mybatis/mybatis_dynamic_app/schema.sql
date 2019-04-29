create database mybatis_dynamic_db;
use mybatis_dynamic_db;
create table user(
id int primary key auto_increment,
username varchar(20),
password varchar(20),
sex varchar(10),
age int,
phone varchar(20),
address varchar(20));

insert into user(username,password,sex,age,phone,address) values('Tom','123456','male',18,'18200123456','chengdu');
