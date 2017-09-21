/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log : Database - lessontieshou
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lessontieshou` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lessontieshou`;

/*Table structure for table `study` */

DROP TABLE IF EXISTS `study`;

CREATE TABLE `study` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '学生id号',
  `username` varchar(30) NOT NULL DEFAULT '' COMMENT '学生名字',
  `class` tinyint(3) unsigned NOT NULL,
  `sex` enum('男','女','保密') NOT NULL DEFAULT '保密' COMMENT '性别',
  `addtime` int(10) NOT NULL DEFAULT '0',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='学生表';

/*Data for the table `study` */

insert  into `study`(`id`,`username`,`class`,`sex`,`addtime`,`password`) values (1,'小王',1,'保密',0,'123456'),(2,'小四',2,'女',0,'321654'),(3,'小王',1,'男',5,'12345'),(4,'小四',2,'女',7,'123213');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
