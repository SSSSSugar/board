/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 100411
Source Host           : localhost:3306
Source Database       : note

Target Server Type    : MYSQL
Target Server Version : 100411
File Encoding         : 65001

Date: 2020-07-03 16:18:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1001', '1001');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `noteid` int(20) NOT NULL AUTO_INCREMENT,
  `note` varchar(255) DEFAULT NULL,
  `username` varchar(20) NOT NULL DEFAULT '',
  `time` datetime DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`noteid`),
  KEY `noteuser` (`username`),
  CONSTRAINT `noteuser` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('9', '测试修改功能', '1', '2020-07-03 14:21:55');
INSERT INTO `note` VALUES ('10', 'ææ¯æµè¯', '1', '2020-07-02 22:12:33');
INSERT INTO `note` VALUES ('11', 'ææ¯æµè¯', '1', '2020-07-02 22:14:54');
INSERT INTO `note` VALUES ('12', '我是测试', '1', '2020-07-03 10:25:05');
INSERT INTO `note` VALUES ('13', '我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试', '1', '2020-07-03 10:25:18');
INSERT INTO `note` VALUES ('14', '我是测试2', '1', '2020-07-03 10:25:23');
INSERT INTO `note` VALUES ('15', '我是跳转测试', '1', '2020-07-03 10:25:34');
INSERT INTO `note` VALUES ('16', '我是测试内容', 'test', '2020-07-03 15:19:06');
INSERT INTO `note` VALUES ('18', '我是修改过后的修改测试内容', 'test', '2020-07-03 15:24:14');
INSERT INTO `note` VALUES ('19', '我是查看测试内容1', 'test', '2020-07-03 15:24:59');
INSERT INTO `note` VALUES ('20', '我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容我是查看测试内容', 'test', '2020-07-03 15:26:32');
INSERT INTO `note` VALUES ('21', '测试删除的内容', 'test', '2020-07-03 16:10:22');

-- ----------------------------
-- Table structure for pwdnote
-- ----------------------------
DROP TABLE IF EXISTS `pwdnote`;
CREATE TABLE `pwdnote` (
  `pwdnoteid` int(11) NOT NULL AUTO_INCREMENT,
  `pwdnote` varchar(255) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `time` datetime DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`pwdnoteid`),
  KEY `pwduser` (`username`),
  CONSTRAINT `pwduser` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pwdnote
-- ----------------------------
INSERT INTO `pwdnote` VALUES ('1', 'gitee suuuu zxcvbnm123', '1', '2020-07-03 14:33:48');
INSERT INTO `pwdnote` VALUES ('2', 'qq 账号：1233 密码：31123', '1', '2020-07-03 01:19:06');
INSERT INTO `pwdnote` VALUES ('5', 'msi 119291@qq.com 12341', 'test', '2020-07-03 16:09:13');
INSERT INTO `pwdnote` VALUES ('7', '我是密码本测试用例通过修改方法修改过后的修改内容', 'test', '2020-07-03 16:15:14');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL DEFAULT '',
  `secpwd` varchar(20) NOT NULL,
  `realname` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', '1', '1', '123', '1', '1');
INSERT INTO `user` VALUES ('5', '2', '2', '2', '2', '2');
INSERT INTO `user` VALUES ('6', '1001', '123', '123', '1', '1');
INSERT INTO `user` VALUES ('8', '123', '123', '123', '123', '123@111.com');
INSERT INTO `user` VALUES ('9', '1233', '321', '321', '测试', '123@qq.com');
INSERT INTO `user` VALUES ('10', 'test', 'test', '1234', '测试', '1001@111.com');
SET FOREIGN_KEY_CHECKS=1;
