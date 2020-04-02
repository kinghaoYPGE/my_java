create database ssm_resume_db;
use ssm_resume_db;

CREATE TABLE `resume`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50),
  `gender` varchar(4),
  `age` int(11) NULL DEFAULT NULL,
  `address` varchar(40),
  `email` varchar(70),
  `tel` varchar(13),
  `introduce` varchar(800),
  `major` varchar(20),
  `education` varchar(20),
  `school` varchar(50),
  `graduation` varchar(60),
  `company` varchar(30),
  `position` varchar(50),
  `duty` varchar(30),
  `departure` varchar(30),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;
