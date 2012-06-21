/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : 192.168.1.204:3306
Source Database       : edm

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2012-04-20 17:24:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `connName` varchar(255) DEFAULT NULL,
  `connPhone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'jkdun', '终端机', '杜松', '13760672695', '东风东路');
INSERT INTO `department` VALUES ('2', 'jkdun2', '终端', '杜松', '13670762795', '东风东路');
INSERT INTO `department` VALUES ('3', 'jkdun3', '终端', '杜松', '13670762795', '东风东路');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `departmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleId`),
  KEY `departmentid` (`departmentId`),
  KEY `emailIndex` (`email`),
  CONSTRAINT `departmentid` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`),
  CONSTRAINT `roleid` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('dillisbest@gmail.com', 'dill', 'dusong', '1', null, null);
INSERT INTO `user` VALUES ('dillisbest@163.com', 'dill', 'dusong163', '2', null, null);
INSERT INTO `user` VALUES ('dusong@g2.com', 'dill', 'dusong2', '4', null, null);
INSERT INTO `user` VALUES ('dillisbest@gmail2.com', 'd', 'dusong1', '5', null, null);
INSERT INTO `user` VALUES ('dusong@qq.com', 'dill', 'dusongqq', '6', null, null);
INSERT INTO `user` VALUES ('selma@gmail.com', '2BFA99427EEF278FF198A11CDAAF2B35', 'selma', '7', null, '1');
