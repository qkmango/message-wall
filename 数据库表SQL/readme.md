# 数据库SQL

首先要有以一个名为`messagewall`的数据库，在此基础上有两张表`user`表和`message`表
> 文件夹中包含user表和message表，并且有两种分类，仅表结构的和表结构和数据的；表结构和数据的，里面的数据为测试数据
## user表
````sql
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

SET FOREIGN_KEY_CHECKS = 1;
````

## message表
````sql
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

SET FOREIGN_KEY_CHECKS = 1;
````