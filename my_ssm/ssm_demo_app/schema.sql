create database ssm_demo_db;
use ssm_demo_db;
create table user(
    id int primary key auto_increment,
    username varchar(20),
    password varchar(20),
    sex varchar(10),
    age int
);
insert into user(username,password,sex,age) value('zhangsan','123456','male',22);
