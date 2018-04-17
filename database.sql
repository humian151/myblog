/*
SQLyog Ultimate v10.00 Beta1
MySQL - 6.0.11-alpha-community : Database - myblog2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`myblog2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `myblog2`;

/*Table structure for table `article_inf` */

DROP TABLE IF EXISTS `article_inf`;

CREATE TABLE `article_inf` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `content` mediumtext COMMENT '内容',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `modi_time` date DEFAULT NULL COMMENT '修改时间',
  `title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `ispublish` char(1) NOT NULL DEFAULT '0' COMMENT '是否发布，0未发布，1发布',
  `link` varchar(255) DEFAULT NULL COMMENT '文章链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;

/*Data for the table `article_inf` */

insert  into `article_inf`(`id`,`content`,`create_time`,`modi_time`,`title`,`author`,`ispublish`,`link`) values (1,'《名侦探柯南：贝克街的亡灵》是根据日本漫画家青山刚昌创作的漫画《名侦探柯南》改编的系列动画电影的第6部作品。影片讲述了少年侦探柯南挑战虚拟体感游戏过程中追寻解开杀人事件真相的线索并活跃行动的故事。影片于2002年4月20日在日本首映。该影片曾位列名侦探柯南剧场版历代19部作品人气投票最终结果第2位。','2018-04-10','2018-04-12','贝克街的亡灵','青山刚昌','1',NULL),(2,'管理员顾测试测试标题s','2018-04-13','2018-04-13','管理员顾测试','管理员','1',NULL),(3,'管理员顾测试测试标题管理员顾测试测试标题管理员顾测试测试标题管理员顾测试测试标题管理员顾测试测试标题管理员顾测试测试标题管理员顾测试测试标题管理员顾测试测试标题','2018-04-09','2018-04-13','管理员顾测试','管理员','1',NULL),(4,'<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;忙碌的生活，浮躁的心情，有时候我们会忘记这个世界也许比我们以为的要多彩。如果我们愿意让自己偶尔停下脚步，用心看看身边的一切，就会发现这个世界如此可爱。为了让生活的色彩更加浓烈，最近喜欢把照片的背景图成黑白，喜欢用这种方式来提醒自己，原来生活如此多彩，即使我如此平凡。</p>\r\n									<p class=\"msg_img\">\r\n										<a href=\"http://upload-images.jianshu.io/upload_images/2459311-219d0ec8f559fc96.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240\"  class=\"swipebox\" >\r\n											<img src=\"http://upload-images.jianshu.io/upload_images/2459311-219d0ec8f559fc96.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240\" class=\"img-thumbnail\" alt=\"image\">\r\n										</a>\r\n										<a href=\"http://upload-images.jianshu.io/upload_images/2459311-799dc150681659ce.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240\"  class=\"swipebox\" >\r\n											<img src=\"http://upload-images.jianshu.io/upload_images/2459311-799dc150681659ce.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240\" class=\"img-thumbnail\" alt=\"image\">\r\n										</a>\r\n										<a href=\"http://upload-images.jianshu.io/upload_images/2459311-5d8666c80f0e2115.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240\"  class=\"swipebox\"  >\r\n											<img src=\"http://upload-images.jianshu.io/upload_images/2459311-5d8666c80f0e2115.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240\" class=\"img-thumbnail\" alt=\"image\">\r\n										</a>\r\n									</p>','2018-04-13','2018-04-13','生活未必多精彩，但必定多彩','梦回起点','1',NULL);

/*Table structure for table `articlelist_inf` */

DROP TABLE IF EXISTS `articlelist_inf`;

CREATE TABLE `articlelist_inf` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `love_count` int(9) DEFAULT '0' COMMENT '喜欢数量',
  `collect_count` int(9) DEFAULT '0' COMMENT '收藏数量',
  `article_id` bigint(11) DEFAULT NULL COMMENT '关联主表主键',
  PRIMARY KEY (`id`),
  KEY `FK4tkpm39b7uwd9pwasberfqe7a` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `articlelist_inf` */

insert  into `articlelist_inf`(`id`,`love_count`,`collect_count`,`article_id`) values (1,15,11,4);

/*Table structure for table `author_inf` */

DROP TABLE IF EXISTS `author_inf`;

CREATE TABLE `author_inf` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `avatar_path` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `author_inf` */

insert  into `author_inf`(`id`,`author`,`avatar_path`,`create_time`) values (1,'梦回起点','image/01_100.jpg','2018-04-17');

/*Table structure for table `user_inf` */

DROP TABLE IF EXISTS `user_inf`;

CREATE TABLE `user_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) NOT NULL,
  `password` varchar(16) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(20) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `tel_phone` bigint(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_inf` */

insert  into `user_inf`(`id`,`loginname`,`password`,`status`,`createDate`,`username`,`role_id`,`tel_phone`,`email`) values (1,'admin','123456',1,'2017-08-23 10:36:00','系统管理员',2,12345343232,NULL),(2,'dev','1',1,'2017-10-11 09:47:23','dev',NULL,NULL,NULL),(3,'test1','1',1,'2017-10-11 09:50:08','系统测试号',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
