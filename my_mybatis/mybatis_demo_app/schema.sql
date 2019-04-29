create database mybatis_demo_db;

create table tb_head_teacher(
ht_id int primary key auto_increment,
ht_name varchar(20),
ht_age int);

insert into tb_head_teacher(ht_name,ht_age) values('ZhangSan',40);

create table tb_class(
c_id int primary key auto_increment,
c_name varchar(20),
c_ht_id int unique,
foreign key(c_ht_id) references tb_head_teacher(ht_id));

insert into tb_class(c_name,c_ht_id) values('Class One',1);

create table tb_student(
s_id int primary key auto_increment,
s_name varchar(20),
s_sex varchar(10),
s_age int,
s_c_id int,
foreign key(s_c_id) references tb_class(c_id));

insert into tb_student(s_name,s_sex,s_age,s_c_id) values('Tom','male',18,1);
insert into tb_student(s_name,s_sex,s_age,s_c_id) values('Jack','male',19,1);
insert into tb_student(s_name,s_sex,s_age,s_c_id) values('Rose','female',18,1);

create table tb_course(
c_id int primary key auto_increment,
c_name varchar(20),
c_credit int);

insert into tb_course(c_name,c_credit) values('Math',5);
insert into tb_course(c_name,c_credit) values('Computer',4);

# student和course的中间表
create table tb_select_course(
sc_s_id int,
sc_c_id int,
sc_date date,
primary key(sc_s_id,sc_c_id),
foreign key(sc_s_id) references tb_student(s_id),
foreign key(sc_c_id) references tb_course(c_id));

insert into tb_select_course(sc_s_id,sc_c_id,sc_date) values(1,1,'2017-03-01');
insert into tb_select_course(sc_s_id,sc_c_id,sc_date) values(1,2,'2017-03-01');
insert into tb_select_course(sc_s_id,sc_c_id,sc_date) values(2,1,'2017-03-02');
insert into tb_select_course(sc_s_id,sc_c_id,sc_date) values(2,2,'2017-03-02');