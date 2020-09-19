/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : messagewall

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 19/09/2020 22:07:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `mid` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) UNSIGNED NOT NULL COMMENT '留言者id',
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '留言对象姓名',
  `date` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '留言日期',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '留言内容',
  `anony` tinyint(1) NOT NULL COMMENT '留言者是否匿名',
  `color` tinyint(2) NOT NULL COMMENT '留言板样式颜色',
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, '程粥', '2020-09-19', '嘿嘿嘿', 1, 5);
INSERT INTO `message` VALUES (2, 2, '芒果小洛', '2020-09-19', '哈哈哈哈', 1, 4);
INSERT INTO `message` VALUES (3, 3, '芒果小洛', '2020-09-19', '哈哈哈哈测试', 1, 3);
INSERT INTO `message` VALUES (4, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (5, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (6, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (7, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (8, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (9, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (10, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (11, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (12, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (13, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (14, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (15, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (16, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (17, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (18, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (19, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (20, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (21, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (22, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (23, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (24, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (25, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (26, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (27, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (28, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (29, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (30, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (31, 3, 'ME', '2020-09-19', 'TEST', 0, 1);
INSERT INTO `message` VALUES (32, 3, 'ME', '2020-09-19', 'TEST', 1, 1);
INSERT INTO `message` VALUES (33, 3, 'ME', '2020-09-19', 'TEST', 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
