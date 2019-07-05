--liquibase formatted sql
--changeset ReMidDream:init

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cinema
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema`  (
  `cinema_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cinema_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cinema_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `feedback_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`feedback_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `movie_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '上映时间',
  `running_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电影时长',
  `movie_describe` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `movie_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`movie_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Table structure for screening
-- ----------------------------
DROP TABLE IF EXISTS `screening`;
CREATE TABLE `screening`  (
  `screening_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `screens_id` bigint(20) NOT NULL COMMENT '影厅id',
  `movie_id` bigint(20) NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`screening_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for screens
-- ----------------------------
DROP TABLE IF EXISTS `screens`;
CREATE TABLE `screens`  (
  `screens_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `screens_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`screens_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for screens_seat
-- ----------------------------
DROP TABLE IF EXISTS `screens_seat`;
CREATE TABLE `screens_seat`  (
  `screens_seat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `screens_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `column_number` int(11) NULL DEFAULT NULL,
  `row_number` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`screens_seat_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket`  (
  `ticket_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) NULL DEFAULT NULL,
  `ticket_status` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `screening_id` bigint(20) NULL DEFAULT NULL,
  `screening_column` int(255) NULL DEFAULT NULL,
  `screening_row` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ticket_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
