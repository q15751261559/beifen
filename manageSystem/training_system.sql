/*
 Navicat MySQL Data Transfer

 Source Server         : mysql57
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : training_system

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 11/01/2021 23:09:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for 产品
-- ----------------------------
DROP TABLE IF EXISTS `产品`;
CREATE TABLE `产品`  (
  `产品编号` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `产品名称` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `生产日期` datetime(0) NOT NULL,
  `产品类型` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `价格` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`产品编号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of 产品
-- ----------------------------
INSERT INTO `产品` VALUES ('1', 'Java', '2020-12-30 08:27:47', '软件', '500');
INSERT INTO `产品` VALUES ('2', 'Python', '2020-12-30 08:27:47', 'AI', '1000');
INSERT INTO `产品` VALUES ('3', 'Go', '2020-12-30 08:30:40', '服务器', '1500');

-- ----------------------------
-- Table structure for 任务计划
-- ----------------------------
DROP TABLE IF EXISTS `任务计划`;
CREATE TABLE `任务计划`  (
  `任务计划编号` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `联系人编号` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `客户数量` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `计划利润` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `计划时间` datetime(0) NOT NULL,
  `实施情况` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '否',
  PRIMARY KEY (`任务计划编号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of 任务计划
-- ----------------------------
INSERT INTO `任务计划` VALUES ('1', '001', '1', '500', '2020-12-30 08:28:26', '否');

-- ----------------------------
-- Table structure for 反馈信息
-- ----------------------------
DROP TABLE IF EXISTS `反馈信息`;
CREATE TABLE `反馈信息`  (
  `反馈编号` int(11) NOT NULL AUTO_INCREMENT,
  `反馈人姓名` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `反馈时间` datetime(0) NOT NULL,
  `反馈内容` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `产品编号` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `解决情况` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '否',
  PRIMARY KEY (`反馈编号`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of 反馈信息
-- ----------------------------

-- ----------------------------
-- Table structure for 客户
-- ----------------------------
DROP TABLE IF EXISTS `客户`;
CREATE TABLE `客户`  (
  `客户编号` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `客户姓名` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `联系方式` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `联系地址` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `信用度` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`客户编号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of 客户
-- ----------------------------
INSERT INTO `客户` VALUES ('1', '浅梦', '794359756', '江苏省无锡市新吴区', '100');
INSERT INTO `客户` VALUES ('2', '小浅梦', '2711664223', '江苏省南京市栖霞区', '100');
INSERT INTO `客户` VALUES ('3', '小南风', '12199193258', '浙江省杭州市拱墅区', '100');

-- ----------------------------
-- Table structure for 联系人
-- ----------------------------
DROP TABLE IF EXISTS `联系人`;
CREATE TABLE `联系人`  (
  `联系人编号` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `姓名` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `所属部门` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `产品类型` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `任务计划编号` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `工资` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `联系方式` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`联系人编号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of 联系人
-- ----------------------------
INSERT INTO `联系人` VALUES ('001', '南风', '销售部', '软件', '1', '1000', '2711664540');

-- ----------------------------
-- Table structure for 订单
-- ----------------------------
DROP TABLE IF EXISTS `订单`;
CREATE TABLE `订单`  (
  `订单编号` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `订单产品` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `购买时间` datetime(0) NOT NULL,
  `消费客户` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`订单编号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 订单
-- ----------------------------
INSERT INTO `订单` VALUES ('1', '1', '2021-01-11 02:06:30', '2');
INSERT INTO `订单` VALUES ('2', '2', '2021-01-11 00:18:13', '2');
INSERT INTO `订单` VALUES ('3', '3', '2021-01-11 03:02:52', '1');

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号，主键',
  `account` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '账户\r\n',
  `password` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '密码',
  `admin_name` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL COMMENT '名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, '123456', 'e10adc3949ba59abbe56e057f20f883e', '测试帐号');

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) NOT NULL COMMENT '院系id',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES (1, 3, '航空1001');
INSERT INTO `t_class` VALUES (2, 3, '航空1002');
INSERT INTO `t_class` VALUES (4, 7, '经贸1001');
INSERT INTO `t_class` VALUES (5, 7, '经贸1002');
INSERT INTO `t_class` VALUES (6, 7, '经贸1003');
INSERT INTO `t_class` VALUES (10, 1, '机械1001');
INSERT INTO `t_class` VALUES (11, 1, '机械1002');
INSERT INTO `t_class` VALUES (12, 1, '机械1003');
INSERT INTO `t_class` VALUES (15, 2, '电气1001');
INSERT INTO `t_class` VALUES (16, 2, '电气1002');
INSERT INTO `t_class` VALUES (17, 2, '电气1003');
INSERT INTO `t_class` VALUES (20, 0, '汽车1003');
INSERT INTO `t_class` VALUES (24, 3, '航空1003');
INSERT INTO `t_class` VALUES (25, 5, '软件1001');
INSERT INTO `t_class` VALUES (26, 5, '软件1002');
INSERT INTO `t_class` VALUES (27, 5, '软件1003');
INSERT INTO `t_class` VALUES (28, 6, '艺术1001');
INSERT INTO `t_class` VALUES (32, 6, '艺术1002');
INSERT INTO `t_class` VALUES (33, 6, '艺术1003');
INSERT INTO `t_class` VALUES (34, 8, '经管1001');
INSERT INTO `t_class` VALUES (35, 8, '经管1002');
INSERT INTO `t_class` VALUES (36, 8, '经管1003');
INSERT INTO `t_class` VALUES (37, 4, '汽车1001');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院系名称',
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院系logo',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES (1, '机械工程学院', 'file:///C:/Users/33285/Desktop/图片1/1.jpg');
INSERT INTO `t_department` VALUES (2, '电气工程学院', 'file:///C:/Users/33285/Desktop/图片1/2.jpg');
INSERT INTO `t_department` VALUES (3, '航空工程学院', 'file:///C:/Users/33285/Desktop/图片1/3.jpg');
INSERT INTO `t_department` VALUES (4, '汽车工程学院', 'file:///C:/Users/33285/Desktop/图片1/4.jpg');
INSERT INTO `t_department` VALUES (5, '计算机与软件学院', 'file:///C:/Users/33285/Desktop/图片1/5.jpg');
INSERT INTO `t_department` VALUES (6, '艺术设计学院', 'file:///C:/Users/33285/Desktop/图片1/6.jpg');
INSERT INTO `t_department` VALUES (7, '商务贸易学院', 'file:///C:/Users/33285/Desktop/图片1/7.jpg');
INSERT INTO `t_department` VALUES (8, '经济管理学院', 'file:///C:/Users/33285/Desktop/图片1/8.jpg');

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `member_name` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES (1, '2711664540', 'e10adc3949ba59abbe56e057f20f883e', '南风');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `class_id` int(11) NOT NULL,
  `student_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` tinyint(1) NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2020001', 6, '文进勇', '11111111111', 'file:///C:/Users/33285/Desktop/图片1/1.jpg', 1, '1999-11-11', '北京东路1号');
INSERT INTO `t_student` VALUES ('2020002', 6, '文进一', '11111111111', 'file:///C:/Users/33285/Desktop/图片1/2.jpg', 1, '1999-11-11', '北京东路1号');
INSERT INTO `t_student` VALUES ('2020003', 6, '李俊杰', '22222222222', 'file:///C:\\Users\\33285\\Desktop\\TIM图片20200119141008.jpg', 1, '2020-12-13', '北京西路1号');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_name` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '83228621', 'e10adc3949ba59abbe56e057f20f883e', '浅梦');
INSERT INTO `t_user` VALUES (2, '2711664530', 'e10adc3949ba59abbe56e057f20f883e', '小浅梦');
INSERT INTO `t_user` VALUES (3, '1219919325', 'e10adc3949ba59abbe56e057f20f883e', '小南风');

SET FOREIGN_KEY_CHECKS = 1;
