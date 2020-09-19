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

 Date: 19/09/2020 22:07:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'uid主键',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '昵称',
  `sex` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '性别 女0 男1',
  `regdate` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '2000-05-20' COMMENT '注册日期',
  `birthday` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '2000-05-20' COMMENT '生日',
  `avatar` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像图片base64字符串',
  `qq` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'QQ号',
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号',
  `hide` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '11111' COMMENT '信息隐藏项目JSON',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2099432021@qq.com', 'a111111', '芒果小洛', 1, '2020-09-19', '2000-11-13', '#icon-icon-test15', '2099432021', '15178140229', '11110');
INSERT INTO `user` VALUES (2, '2099432021@cc.c', 'a111111', '程粥', 0, '2020-09-19', '2000-05-20', NULL, '', '', '11111');
INSERT INTO `user` VALUES (3, 'test@tt.t', 'a111111', '测试', 0, '2020-09-19', '2000-05-20', '#icon-icon-test8', '123456345', '15178100000', '11001');

SET FOREIGN_KEY_CHECKS = 1;
