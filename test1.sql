/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80025
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2021-06-28 23:18:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_admin
-- ----------------------------
DROP TABLE IF EXISTS `s_admin`;
CREATE TABLE `s_admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of s_admin
-- ----------------------------
INSERT INTO `s_admin` VALUES ('1', 'root', '123456', '2021-05-08 14:24:09');
INSERT INTO `s_admin` VALUES ('2', 'admin', '123456', '2021-06-24 11:37:40');

-- ----------------------------
-- Table structure for s_attendance
-- ----------------------------
DROP TABLE IF EXISTS `s_attendance`;
CREATE TABLE `s_attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `attendance_date` varchar(12) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_attendance_foreign` (`student_id`),
  KEY `course_attendance_foreign` (`course_id`),
  CONSTRAINT `course_attendance_foreign` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`),
  CONSTRAINT `student_attendance_foreign` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of s_attendance
-- ----------------------------
INSERT INTO `s_attendance` VALUES ('1', '1', '1', '2021-05-08');
INSERT INTO `s_attendance` VALUES ('2', '1', '2', '2021-05-08');
INSERT INTO `s_attendance` VALUES ('3', '1', '3', '2021-05-08');
INSERT INTO `s_attendance` VALUES ('4', '1', '5', '2021-05-08');
INSERT INTO `s_attendance` VALUES ('34', '1', '4', '2021-06-03');

-- ----------------------------
-- Table structure for s_class
-- ----------------------------
DROP TABLE IF EXISTS `s_class`;
CREATE TABLE `s_class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `info` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of s_class
-- ----------------------------
INSERT INTO `s_class` VALUES ('1', '翠英1班', '翠英1班');
INSERT INTO `s_class` VALUES ('2', '翠英2班', '翠英2班');
INSERT INTO `s_class` VALUES ('3', '翠英3班', '翠英3班');
INSERT INTO `s_class` VALUES ('4', '翠英4班', '翠英4班');
INSERT INTO `s_class` VALUES ('5', '翠英5班', '翠英5班');

-- ----------------------------
-- Table structure for s_course
-- ----------------------------
DROP TABLE IF EXISTS `s_course`;
CREATE TABLE `s_course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `teacher_id` int NOT NULL,
  `max_student_num` int NOT NULL,
  `info` varchar(512) DEFAULT NULL,
  `selected_num` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `teacher_foreign` (`teacher_id`),
  CONSTRAINT `teacher_foreign` FOREIGN KEY (`teacher_id`) REFERENCES `s_teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of s_course
-- ----------------------------
INSERT INTO `s_course` VALUES ('1', 'java程序设计', '1', '60', '很重要哦，必拿满分！', '0');
INSERT INTO `s_course` VALUES ('2', 'C语言设计', '2', '60', 'hello world', '0');
INSERT INTO `s_course` VALUES ('3', '大学英语', '4', '60', 'english', '0');
INSERT INTO `s_course` VALUES ('4', 'Linux', '6', '60', '学习一门新系统，为以后云服务器打下基础', '0');
INSERT INTO `s_course` VALUES ('5', '高等数学', '3', '60', '数学的习题课', '0');

-- ----------------------------
-- Table structure for s_score
-- ----------------------------
DROP TABLE IF EXISTS `s_score`;
CREATE TABLE `s_score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `score` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_score_foreign` (`student_id`),
  KEY `course_id_score_foreign` (`course_id`),
  CONSTRAINT `course_id_score_foreign` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`),
  CONSTRAINT `student_score_foreign` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of s_score
-- ----------------------------
INSERT INTO `s_score` VALUES ('16', '1', '1', '100');
INSERT INTO `s_score` VALUES ('17', '1', '2', '100');
INSERT INTO `s_score` VALUES ('18', '1', '4', '100');
INSERT INTO `s_score` VALUES ('19', '1', '5', '100');

-- ----------------------------
-- Table structure for s_selected_course
-- ----------------------------
DROP TABLE IF EXISTS `s_selected_course`;
CREATE TABLE `s_selected_course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_foreign` (`student_id`),
  KEY `course_foreign` (`course_id`),
  CONSTRAINT `course_foreign` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`),
  CONSTRAINT `student_foreign` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of s_selected_course
-- ----------------------------
INSERT INTO `s_selected_course` VALUES ('1', '1', '1');
INSERT INTO `s_selected_course` VALUES ('2', '1', '2');
INSERT INTO `s_selected_course` VALUES ('3', '1', '3');
INSERT INTO `s_selected_course` VALUES ('4', '1', '4');
INSERT INTO `s_selected_course` VALUES ('5', '1', '5');
INSERT INTO `s_selected_course` VALUES ('6', '2', '1');
INSERT INTO `s_selected_course` VALUES ('7', '2', '5');
INSERT INTO `s_selected_course` VALUES ('8', '3', '1');
INSERT INTO `s_selected_course` VALUES ('9', '4', '2');
INSERT INTO `s_selected_course` VALUES ('10', '5', '5');
INSERT INTO `s_selected_course` VALUES ('11', '6', '3');
INSERT INTO `s_selected_course` VALUES ('12', '6', '4');
INSERT INTO `s_selected_course` VALUES ('13', '7', '1');

-- ----------------------------
-- Table structure for s_student
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `classId` int NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `new` (`classId`) USING BTREE,
  CONSTRAINT `class_foreign` FOREIGN KEY (`classId`) REFERENCES `s_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of s_student
-- ----------------------------
INSERT INTO `s_student` VALUES ('1', '张三', '1', '1', '女');
INSERT INTO `s_student` VALUES ('2', '李四', '2', '2', '男');
INSERT INTO `s_student` VALUES ('3', '王五', '3', '3', '男');
INSERT INTO `s_student` VALUES ('4', '狗六', '4', '4', '男');
INSERT INTO `s_student` VALUES ('5', '刘七', '5', '5', '男');
INSERT INTO `s_student` VALUES ('6', '小吴', '3', '6', '保密');
INSERT INTO `s_student` VALUES ('7', 'jacky', '5', '7', '男');

-- ----------------------------
-- Table structure for s_teacher
-- ----------------------------
DROP TABLE IF EXISTS `s_teacher`;
CREATE TABLE `s_teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `title` varchar(32) NOT NULL,
  `age` int NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of s_teacher
-- ----------------------------
INSERT INTO `s_teacher` VALUES ('1', '苑', '女', '数据库教师', '40', 'yuan');
INSERT INTO `s_teacher` VALUES ('2', '陈', '女', 'C语言教师', '40', 'chen');
INSERT INTO `s_teacher` VALUES ('3', '夏', '女', '高等数学教师', '34', 'xia');
INSERT INTO `s_teacher` VALUES ('4', '勾', '女', '英语教师', '27', 'gou');
INSERT INTO `s_teacher` VALUES ('5', '喻', '男', '校长', '40', 'yang');
INSERT INTO `s_teacher` VALUES ('6', '张', '女', 'Linux教师', '40', 'zhang');

-- ----------------------------
-- View structure for 查看当前所有学生性别和所在班级，并显示该班级简介
-- ----------------------------
DROP VIEW IF EXISTS `查看当前所有学生性别和所在班级，并显示该班级简介`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `查看当前所有学生性别和所在班级，并显示该班级简介` AS select `s_student`.`sex` AS `sex`,`s_student`.`name` AS `name`,`s_student`.`id` AS `id`,`s_class`.`info` AS `info` from (`s_student` join `s_class` on((`s_student`.`classId` = `s_class`.`id`))) ;
