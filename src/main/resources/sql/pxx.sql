/*
SQLyog Trial v13.1.8 (64 bit)
MySQL - 8.0.28-0ubuntu0.20.04.3 : Database - pxx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pxx` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `pxx`;

/*Table structure for table `bill` */

DROP TABLE IF EXISTS `bill`;

CREATE TABLE `bill` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `billCode` varchar(20) NOT NULL COMMENT '订单号',
  `goodCode` bigint NOT NULL COMMENT '商品编号',
  `quantity` bigint NOT NULL COMMENT '购买数量',
  `goodPrice` double NOT NULL COMMENT '商品单价',
  `totalPrice` double NOT NULL COMMENT '总价',
  `customerCode` bigint DEFAULT NULL COMMENT '顾客编号',
  `address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '配送地址',
  `billTime` datetime DEFAULT NULL COMMENT '下单时间',
  `paymentMethod` bigint NOT NULL COMMENT '支付方式',
  `deliveryTime` datetime DEFAULT NULL COMMENT '配送时间',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `version` bigint NOT NULL DEFAULT '1',
  `deleted` int NOT NULL DEFAULT '0',
  `goodCount` bigint DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `bill` */

insert  into `bill`(`id`,`billCode`,`goodCode`,`quantity`,`goodPrice`,`totalPrice`,`customerCode`,`address`,`billTime`,`paymentMethod`,`deliveryTime`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`,`version`,`deleted`,`goodCount`) values 
(8,'10',1,24,5.3,127.2,2,'','2022-03-27 18:00:00',1,NULL,1,'2022-03-27 18:00:00',1,'2022-03-27 09:40:33',1,0,NULL),
(10,'133',1,24,5.3,127.2,2,'中国','2022-03-27 10:30:52',1,NULL,1,'2022-03-27 10:30:52',NULL,NULL,1,0,NULL);

/*Table structure for table `bill_good` */

DROP TABLE IF EXISTS `bill_good`;

CREATE TABLE `bill_good` (
  `billCode` bigint NOT NULL COMMENT '订单id',
  `goodCode` bigint NOT NULL COMMENT '商品id',
  `quantity` bigint NOT NULL COMMENT '数量',
  `price` double NOT NULL COMMENT '单价',
  `creationBy` bigint DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `modifyBy` bigint DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `version` bigint DEFAULT '1',
  `deleted` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `bill_good` */

/*Table structure for table `good` */

DROP TABLE IF EXISTS `good`;

CREATE TABLE `good` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `goodCode` varchar(15) NOT NULL COMMENT '商品编号',
  `parentType` bigint NOT NULL COMMENT '商品父类别',
  `goodName` varchar(20) NOT NULL COMMENT '商品名',
  `inventory` bigint NOT NULL COMMENT '商品库存',
  `owner` bigint NOT NULL COMMENT '商品拥有者(取自用户表)',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `version` bigint NOT NULL DEFAULT '1',
  `deleted` int NOT NULL DEFAULT '0',
  `childType` bigint DEFAULT NULL COMMENT '商品子类别',
  `details` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `good` */

insert  into `good`(`id`,`goodCode`,`parentType`,`goodName`,`inventory`,`owner`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`,`version`,`deleted`,`childType`,`details`) values 
(1,'1',2,'脉动',500,2,0,NULL,1,'2022-05-06 19:02:26',2,0,NULL,NULL),
(2,'2',1,'辣条',100,2,0,NULL,1,'2022-03-13 11:16:38',1,0,NULL,NULL),
(3,'1919810',1,'红茶',114514,2,1,'2022-03-13 16:29:22',NULL,NULL,1,0,NULL,NULL),
(6,'233',1,'临',1,4,4,'2022-03-13 17:10:44',NULL,NULL,1,0,NULL,NULL),
(11,'13',1,'脉动',114514,2,1,'2022-03-13 22:47:50',1,'2022-05-04 15:52:01',2,0,NULL,NULL),
(14,'19198100',1,'新鲜的',100,2,1,'2022-03-16 21:16:06',1,'2022-05-04 15:52:23',2,0,NULL,NULL),
(18,'114515',2,'太新鲜的',1919,2,1,'2022-03-26 23:09:10',1,'2022-05-04 15:52:48',4,0,NULL,NULL),
(19,'19',1,'新鲜的',100,1,1,'2022-03-27 00:42:01',1,'2022-05-04 15:52:12',2,0,NULL,NULL),
(1521732820681482241,'131331',1,'1',114514,2,NULL,NULL,NULL,NULL,1,0,NULL,NULL);

/*Table structure for table `good_description` */

DROP TABLE IF EXISTS `good_description`;

CREATE TABLE `good_description` (
  `id` bigint NOT NULL,
  `description` longtext COLLATE utf8mb4_general_ci,
  `createdBy` bigint DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `modifyBy` bigint DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `version` bigint NOT NULL DEFAULT '1',
  `deleted` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `good_description` */

/*Table structure for table `good_details` */

DROP TABLE IF EXISTS `good_details`;

CREATE TABLE `good_details` (
  `id` bigint NOT NULL,
  `cover` longtext COLLATE utf8mb4_general_ci,
  `title` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `createdBy` bigint DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `modifyBy` bigint DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `version` bigint NOT NULL DEFAULT '1',
  `deleted` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `good_details` */

/*Table structure for table `good_type` */

DROP TABLE IF EXISTS `good_type`;

CREATE TABLE `good_type` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `typeCode` bigint DEFAULT NULL COMMENT '商品类别编号',
  `typeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品类别名称',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `version` bigint DEFAULT '1',
  `deleted` int DEFAULT '0',
  `parentId` bigint DEFAULT NULL COMMENT '父类别id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

/*Data for the table `good_type` */

insert  into `good_type`(`id`,`typeCode`,`typeName`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`,`version`,`deleted`,`parentId`) values 
(0,3,NULL,0,NULL,0,NULL,1,0,NULL),
(1,1,'饮食',NULL,NULL,NULL,NULL,1,0,NULL),
(2,2,'饮料',NULL,NULL,NULL,NULL,1,0,NULL),
(4,4,'护肤品',NULL,NULL,NULL,NULL,1,0,NULL),
(5,5,'文具',NULL,NULL,NULL,NULL,1,0,NULL),
(6,6,'生活用品',NULL,NULL,NULL,NULL,1,0,NULL);

/*Table structure for table `payment_method` */

DROP TABLE IF EXISTS `payment_method`;

CREATE TABLE `payment_method` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `typeCode` bigint DEFAULT NULL COMMENT '支付方式编号',
  `typeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '支付方式名称',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `version` bigint DEFAULT '1',
  `deleted` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `payment_method` */

insert  into `payment_method`(`id`,`typeCode`,`typeName`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`,`version`,`deleted`) values 
(1,1,'微信',NULL,'2022-03-04 09:22:57',NULL,'2022-03-04 09:22:57',1,0),
(2,2,'支付宝',NULL,'2022-03-04 09:22:57',NULL,'2022-03-04 09:22:57',1,0),
(3,3,'信用卡',NULL,'2022-03-04 09:22:57',NULL,'2022-03-04 09:22:57',1,0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `userCode` varchar(15) NOT NULL COMMENT '用户编码',
  `userName` varchar(15) NOT NULL COMMENT '用户名称',
  `userPassword` varchar(15) NOT NULL COMMENT '用户密码',
  `gender` int NOT NULL COMMENT '性别（1:女、 2:男）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `userRole` bigint NOT NULL COMMENT '用户角色（取自角色表-角色id）',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `version` bigint NOT NULL DEFAULT '1',
  `deleted` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `user` */

insert  into `user`(`id`,`userCode`,`userName`,`userPassword`,`gender`,`birthday`,`phone`,`address`,`userRole`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`,`version`,`deleted`) values 
(1,'admin','admin','123',1,'2010-07-14','13711111110','',1,NULL,'2022-03-04 09:22:57',NULL,NULL,2,0),
(2,'seller','seller','123',2,'2000-07-12','13711111110','',2,0,'2022-03-04 00:00:00',1,NULL,1,0),
(4,'test1','234234','123',1,'2015-10-05','13711111110','',2,NULL,'2022-03-12 17:07:28',NULL,NULL,1,0),
(5,'test2','临临','123123',1,'2016-12-11','13257588051','1',2,0,'2022-03-13 00:00:00',1,'2022-03-16 23:22:00',1,0),
(6,'test3','临临','1231231',1,'2017-03-08','13257588051','1',2,NULL,'2022-03-13 17:46:45',NULL,NULL,1,0),
(11,'test4','test','test',1,'2012-05-10','114514','',2,NULL,'2022-03-20 19:06:16',NULL,NULL,1,0),
(12,'test5','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(13,'test6','test','test',1,'2012-05-10','114514','',2,NULL,NULL,NULL,NULL,1,0),
(14,'test7','test','test',1,'2012-05-10','114514','',2,NULL,NULL,NULL,NULL,1,0),
(15,'test8','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(16,'test9','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(17,'test10','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(18,'test11','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(19,'test12','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(20,'test13','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(21,'test14','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(22,'test15','test','test',1,'2012-05-10','114514',NULL,3,NULL,NULL,NULL,NULL,1,0),
(23,'test16','test','test',1,'2012-05-10','114514',NULL,3,NULL,NULL,NULL,NULL,1,0),
(24,'test17','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(25,'test18','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(26,'test19','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(27,'test20','test','test',1,'2012-05-10','114514',NULL,2,NULL,NULL,NULL,NULL,1,0),
(1521735916375629826,'admin2','admin','123',2,'1981-02-05','13711111110','中国',1,1,'2022-05-04 14:18:10',1,'2022-05-04 14:22:17',2,1),
(1521737006856921089,'admin2','admin','123',1,'2022-05-02','','',1,1,'2022-05-04 14:22:30',1,'2022-05-04 14:22:30',1,0);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `roleCode` bigint DEFAULT NULL COMMENT '角色编码',
  `roleName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `version` bigint DEFAULT '1',
  `deleted` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`roleCode`,`roleName`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`,`version`,`deleted`) values 
(1,1,'admin',NULL,NULL,NULL,NULL,1,0),
(2,2,'商家',NULL,NULL,NULL,NULL,1,0),
(3,3,'顾客',NULL,NULL,NULL,NULL,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
