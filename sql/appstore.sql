/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : 127.0.0.1:3306
Source Database       : appstore

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2014-01-07 10:49:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_chanyue_shouyou_ads
-- ----------------------------
DROP TABLE IF EXISTS `tb_chanyue_shouyou_ads`;
CREATE TABLE `tb_chanyue_shouyou_ads` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '链接',
  `status` varchar(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '显示状态',
  `type` varchar(10) COLLATE utf8_unicode_ci DEFAULT 'index' COMMENT '广告类型',
  `addTime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_chanyue_shouyou_ads
-- ----------------------------

-- ----------------------------
-- Table structure for tb_chanyue_shouyou_game
-- ----------------------------
DROP TABLE IF EXISTS `tb_chanyue_shouyou_game`;
CREATE TABLE `tb_chanyue_shouyou_game` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `gameName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '游戏名称',
  `downloads` int(11) DEFAULT '726' COMMENT '下载次数',
  `size` decimal(10,2) DEFAULT '0.00' COMMENT '文件大小',
  `type` varchar(50) COLLATE utf8_unicode_ci DEFAULT '休闲' COMMENT '游戏类型',
  `tariff` varchar(50) COLLATE utf8_unicode_ci DEFAULT '免费' COMMENT '资费',
  `language` varchar(50) COLLATE utf8_unicode_ci DEFAULT '中文' COMMENT '语言',
  `version` varchar(50) COLLATE utf8_unicode_ci DEFAULT '1.0' COMMENT '版本',
  `update` datetime DEFAULT NULL COMMENT '更新时间',
  `firmware` varchar(50) COLLATE utf8_unicode_ci DEFAULT '2.1及以上' COMMENT '固件版本',
  `developers` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者',
  `download` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '下载地址',
  `introduction` varchar(4000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '应用介绍',
  `features` varchar(4000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新日志',
  `url` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '短信发送地址',
  `platform` varchar(50) COLLATE utf8_unicode_ci DEFAULT '安卓' COMMENT '游戏平台',
  `hot` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '热门',
  `top` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '推荐',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_chanyue_shouyou_game
-- ----------------------------
INSERT INTO `tb_chanyue_shouyou_game` VALUES ('1', '部落守卫战', '726', '22.01', '塔防', '免费', '中文', '1.25', '2013-12-11 15:18:54', '2.1及以上', '腾讯', 'http://url.cn/Ls3sFt', '游戏详情：QQ空间排名第一、最炫塔防战争网游、手机版不删档火爆开启！五大活动迎不删档，开服七天充值双倍返利！亿万勇士翘首以盼的时刻，为您吹响部落守卫战的号角！千变万化的地图和兵种搭配，充满挑战的全新关卡，成长为雄踞一方的部落酋长，争夺称霸世界的荣誉！', '<ul style=\"vertical-align:baseline;color:#666666;font-family:微软雅黑, Tahoma, simsun;background-color:#FFFFFF;\">\r\n	<li style=\"vertical-align:baseline;\">\r\n		修正1.25.0版本问题<br />\r\n1、修正高修显示错误问题<br />\r\n2、修正队列数组问题<br />\r\n3、修正会员城堡礼包显示问题\r\n	</li>\r\n</ul>', null, '安卓', '0', '0');
INSERT INTO `tb_chanyue_shouyou_game` VALUES ('2', '悟空去哪儿', '726', '83.98', '休闲', '免费', '中文', '1.2.25', '2013-12-25 15:11:53', '2.1及以上', null, 'http://url.cn/KaHC6i', null, null, null, '安卓', '0', '0');
INSERT INTO `tb_chanyue_shouyou_game` VALUES ('3', '悟空去哪儿', '726', '84.19', '休闲', '免费', '中文', '1.2.25', '2013-12-25 15:11:56', '2.1及以上', null, 'http://url.cn/QSGJUz', null, null, null, 'IOS', '0', '0');
INSERT INTO `tb_chanyue_shouyou_game` VALUES ('4', '豪胆德州扑克', '726', '8.66', '休闲', '免费', '中文', '2.6', null, '2.1及以上', null, 'http://url.cn/PD74Pb', null, null, null, '安卓', '0', '0');

-- ----------------------------
-- Table structure for tb_chanyue_shouyou_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_chanyue_shouyou_news`;
CREATE TABLE `tb_chanyue_shouyou_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT '0' COMMENT '游戏ID',
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` text COLLATE utf8_unicode_ci COMMENT '内容',
  `author` varchar(50) COLLATE utf8_unicode_ci DEFAULT '8WAN小编' COMMENT '作者',
  `published` datetime DEFAULT NULL COMMENT '发布时间',
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'URL',
  `top` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '置顶',
  `sort` varchar(50) COLLATE utf8_unicode_ci DEFAULT '攻略' COMMENT '内容分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_chanyue_shouyou_news
-- ----------------------------
