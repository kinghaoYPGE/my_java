create database ssm_blog_db;
use ssm_blog_db;
CREATE TABLE `blog` (
  `blogid` int(20) NOT NULL AUTO_INCREMENT,
  `blogtitle` varchar(50) DEFAULT NULL,
  `article` varchar(10000) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`blogid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
insert into blog(blogtitle,article,time) values("The first article","This is the first article to be used for testing",2017-06-01);
CREATE TABLE `diary` (
  `diaryid` int(20) NOT NULL AUTO_INCREMENT,
  `diary` varchar(10000) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`diaryid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
