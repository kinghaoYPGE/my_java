create database springboot_demo_db;
use springboot_demo_db;
CREATE TABLE user
(
    id int PRIMARY KEY AUTO_INCREMENT,
    username varchar(50),
    password varchar(50)
);
