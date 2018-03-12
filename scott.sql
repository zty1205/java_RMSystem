/*
Navicat MySQL Data Transfer

Source Server         : socct
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : scott

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-27 13:59:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dishes
-- ----------------------------
DROP TABLE IF EXISTS `dishes`;
CREATE TABLE `dishes` (
  `DISHID` varchar(50) DEFAULT NULL,
  `DISHNAME` varchar(100) NOT NULL,
  `DISHPRICE` varchar(50) DEFAULT NULL,
  `DISHPOP` varchar(50) DEFAULT NULL,
  `DISHCLASS` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dishes
-- ----------------------------
INSERT INTO `dishes` VALUES ('NTXMHS', '浓汤小米海参', '128', '4', '经典热菜');
INSERT INTO `dishes` VALUES ('CXNNR', '川湘嫩牛肉', '48', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('GGYSS', '干锅野山笋', '48', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('JPNLG', '金牌牛肋骨', '108', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('TXHYTYW', '汤逊湖鱼头鱼丸', '68', '2', '经典热菜');
INSERT INTO `dishes` VALUES ('KWYJC', '口味有机菜', '28', '44', '经典热菜');
INSERT INTO `dishes` VALUES ('DPRHG', '大盘乳黄瓜', '22', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('MPX', '满堂香', '68', '25', '经典热菜');
INSERT INTO `dishes` VALUES ('GTYSY', '宫廷药膳鸭', '68', '12', '透味凉菜');
INSERT INTO `dishes` VALUES ('MHZHL', '美虹醉花螺', '168', '23', '透味凉菜');
INSERT INTO `dishes` VALUES ('ZPHSM', '醉泡花生米', '16', '0', '透味凉菜');
INSERT INTO `dishes` VALUES ('SJHZT', '水晶海蜇头', '48', '51', '透味凉菜');
INSERT INTO `dishes` VALUES ('SKHME', '爽口黑木耳', '18', '57', '透味凉菜');
INSERT INTO `dishes` VALUES ('BZSNG', '冰镇圣女果', '28', '0', '透味凉菜');
INSERT INTO `dishes` VALUES ('ZJRHG', '蘸酱乳黄瓜', '18', '23', '透味凉菜');
INSERT INTO `dishes` VALUES ('LBMD', '凉拌毛豆', '22', '0', '透味凉菜');
INSERT INTO `dishes` VALUES ('GFGY', '古法桂鱼', '108', '014', '经典热菜');
INSERT INTO `dishes` VALUES ('TJSJY', '土鸡烧甲鱼', '128', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('SFJLS', '私房姜辣蛇', '188', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('TSCGY', '特色臭桂鱼', '138', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('YSZSX', '养身煮双鲜', '28', '13', '经典热菜');
INSERT INTO `dishes` VALUES ('CTYJSS', '翅汤有机时蔬', '58', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('XCHNR', '小炒黄牛肉', '48', '12', '经典热菜');
INSERT INTO `dishes` VALUES ('SFSTY', '私房烧鱼头', '78', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('TBNZG', '铁板牛仔骨', '108', '23', '经典热菜');
INSERT INTO `dishes` VALUES ('CXXHG', '菜芯小花菇', '38', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('LHHME', '兰花黑木耳', '28', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('QJCTZR', '青椒炒土猪肉', '36', '65', '经典热菜');
INSERT INTO `dishes` VALUES ('LSBXR', '芦笋爆虾仁', '68', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('GFRY', '古法鲈鱼', '68', '5', '经典热菜');
INSERT INTO `dishes` VALUES ('TZLDF', '土灶老豆腐', '28', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('SFJLNW', '私房姜辣牛蛙', '68', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('THXY', '炭火鲜鱿', '48', '65', '经典热菜');
INSERT INTO `dishes` VALUES ('GFYGX', '古法一罐鲜', '198', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('CZNW', '馋嘴牛蛙', '48', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('ZBTBSY', '滋补铁板山药', '28', '12', '经典热菜');
INSERT INTO `dishes` VALUES ('BYZMPG', '鲍鱼仔焖排骨', '288', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('JGSDYP', '井冈山豆油皮', '32', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('CZSTJ', '柴灶烧土鸡', '58', '59', '经典热菜');
INSERT INTO `dishes` VALUES ('JZGFS', '金针菇粉丝', '26', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('XCHSX', '小炒河三鲜', '38', '56', '经典热菜');
INSERT INTO `dishes` VALUES ('YSLB', '养生萝卜', '24', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('DCSJY', '大厨烧甲鱼', '158', '89', '经典热菜');
INSERT INTO `dishes` VALUES ('HNWGDLB', '黄牛瓦沟炖萝卜', '88', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('SFJLZS', '私房姜辣煮手', '68', '0', '经典热菜');
INSERT INTO `dishes` VALUES ('PGDSR', '排骨蛋烧肉', '68', '12', '经典热菜');
INSERT INTO `dishes` VALUES ('SRZSB', '蒜蓉蒸扇贝', '10', '3', '蒸蒸日上');
INSERT INTO `dishes` VALUES ('LHFGJY', '梁湖风干鲫鱼', '36', '6', '蒸蒸日上');
INSERT INTO `dishes` VALUES ('KWYT', '口味鱼头', '78', '10', '蒸蒸日上');
INSERT INTO `dishes` VALUES ('XRDD', '虾仁炖蛋', '28', '12', '蒸蒸日上');
INSERT INTO `dishes` VALUES ('JYFZR', '酱油份蒸肉', '48', '9', '蒸蒸日上');
INSERT INTO `dishes` VALUES ('SZDPR', '苏州东坡肉', '68', '13', '蒸蒸日上');
INSERT INTO `dishes` VALUES ('PGYPX', '培根一品鲜', '38', '11', '蒸蒸日上');
INSERT INTO `dishes` VALUES ('QZGY', '清蒸桂鱼', '108', '9', '蒸蒸日上');
INSERT INTO `dishes` VALUES ('QZLY', '清蒸鲈鱼', '68', '4', '蒸蒸日上');
INSERT INTO `dishes` VALUES ('HTGK', '红糖锅盔', '18', '1', '主食汤羹');
INSERT INTO `dishes` VALUES ('YZCF', '扬州炒饭', '16', '1', '主食汤羹');
INSERT INTO `dishes` VALUES ('YMDPT', '阴米肚片汤', '42', '1', '主食汤羹');
INSERT INTO `dishes` VALUES ('SRJTJT', '松茸菌土鸡汤', '35', '1', '主食汤羹');
INSERT INTO `dishes` VALUES ('HSWZ', '红薯丸子', '18', '1', '主食汤羹');
INSERT INTO `dishes` VALUES ('HDPGT', '海带排骨汤', '48', '2', '主食汤羹');
INSERT INTO `dishes` VALUES ('ZBYYT', '滋补养颜汤', '22', '1', '主食汤羹');
INSERT INTO `dishes` VALUES ('QTM', '清汤面', '16', '1', '主食汤羹');
INSERT INTO `dishes` VALUES ('MJXTY', '米酒小汤圆', '22', '0', '主食汤羹');
INSERT INTO `dishes` VALUES ('HTSB', '荷塘三宝', '38', '0', '时令蔬菜');
INSERT INTO `dishes` VALUES ('QCXBC', '清炒小白菜', '18', '0', '时令蔬菜');
INSERT INTO `dishes` VALUES ('QCTJ', '清炒苕尖', '18', '0', '时令蔬菜');
INSERT INTO `dishes` VALUES ('BZGDCX', '白灼广东菜芯', '22', '0', '时令蔬菜');
INSERT INTO `dishes` VALUES ('HGHME', '黄瓜黑木耳', '22', '0', '时令蔬菜');
INSERT INTO `dishes` VALUES ('dagao', '蛋糕', '22', '0', '甜点');
INSERT INTO `dishes` VALUES ('冰淇淋', '冰淇淋', '32', '1', '甜点');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `USERID` varchar(50) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `USERPASSWORD` varchar(50) DEFAULT NULL,
  `USERPOSITION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', '黄雪薇', '111', '经理');
INSERT INTO `login` VALUES ('10', '张士现', '111', '保安');
INSERT INTO `login` VALUES ('11', '余宙', '111', '保安');
INSERT INTO `login` VALUES ('12', '王大伟', '111', '厨师');
INSERT INTO `login` VALUES ('13', '吕浩', '111', '端盘');
INSERT INTO `login` VALUES ('14', '付超', '111', '厨师');
INSERT INTO `login` VALUES ('15', '张青阳', '111', '采购');
INSERT INTO `login` VALUES ('16', '宋彩', '111', '收银员');
INSERT INTO `login` VALUES ('17', '王云棋', '111', '收银员');
INSERT INTO `login` VALUES ('18', '刘霏霏', '111', '领班');
INSERT INTO `login` VALUES ('2', '兰彪', '111', '经理');
INSERT INTO `login` VALUES ('3', '孔令良', '111', '主管');
INSERT INTO `login` VALUES ('4', '乔德拴', '111', '厨师');
INSERT INTO `login` VALUES ('5', '党增城', '111', '帮工');
INSERT INTO `login` VALUES ('6', '向泰稳', '111', '扫地');
INSERT INTO `login` VALUES ('7', '李壮', '111', '洗菜');
INSERT INTO `login` VALUES ('8', '任磊', '111', '端盘');
INSERT INTO `login` VALUES ('9', '刘得生', '111', '切菜');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `MENUID` varchar(50) NOT NULL,
  `DISHNAME` varchar(50) DEFAULT NULL,
  `DISHPRICE` varchar(50) DEFAULT NULL,
  `DISHNUMBER` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('24', '珍珠南瓜元', '28', '2');
INSERT INTO `menu` VALUES ('25', '蒜蓉蒸扇贝', '10', '2');
INSERT INTO `menu` VALUES ('25', '清蒸鲈鱼', '68', '3');
INSERT INTO `menu` VALUES ('32', '清蒸桂鱼', '108', '1');
INSERT INTO `menu` VALUES ('33', '酱油份蒸肉', '48', '1');
INSERT INTO `menu` VALUES ('33', '清蒸桂鱼', '108', '1');
INSERT INTO `menu` VALUES ('33', '梁湖风干鲫鱼', '36', '2');
INSERT INTO `menu` VALUES ('35', '清蒸桂鱼', '108', '1');
INSERT INTO `menu` VALUES ('25', '清蒸桂鱼', '108', '1');
INSERT INTO `menu` VALUES ('25', '苏州东坡肉', '68', '2');
INSERT INTO `menu` VALUES ('26', '虾仁炖蛋', '28', '1');
INSERT INTO `menu` VALUES ('28', '虾仁炖蛋', '28', '1');
INSERT INTO `menu` VALUES ('31', '口味鱼头', '78', '2');
INSERT INTO `menu` VALUES ('32', '珍珠南瓜元', '28', '1');
INSERT INTO `menu` VALUES ('33', '阴米肚片汤', '42', '1');
INSERT INTO `menu` VALUES ('33', '红糖锅盔', '18', '1');
INSERT INTO `menu` VALUES ('33', '培根一品鲜', '38', '1');
INSERT INTO `menu` VALUES ('35', '虾仁炖蛋', '28', '1');
INSERT INTO `menu` VALUES ('35', '苏州东坡肉', '68', '1');
INSERT INTO `menu` VALUES ('25', '珍珠南瓜元', '28', '1');
INSERT INTO `menu` VALUES ('24', '虾仁炖蛋', '28', '1');
INSERT INTO `menu` VALUES ('222', '培根一品鲜', '38', '3');
INSERT INTO `menu` VALUES ('25', '梁湖风干鲫鱼', '36', '2');
INSERT INTO `menu` VALUES ('25', '培根一品鲜', '38', '3');
INSERT INTO `menu` VALUES ('27', '清蒸桂鱼', '108', '1');
INSERT INTO `menu` VALUES ('29', '珍珠南瓜元', '28', '1');
INSERT INTO `menu` VALUES ('30', '虾仁炖蛋', '28', '1');
INSERT INTO `menu` VALUES ('31', '珍珠南瓜元', '28', '2');
INSERT INTO `menu` VALUES ('32', '口味鱼头', '78', '1');
INSERT INTO `menu` VALUES ('33', '滋补养颜汤', '22', '1');
INSERT INTO `menu` VALUES ('33', '蒜蓉蒸扇贝', '10', '1');
INSERT INTO `menu` VALUES ('33', '苏州东坡肉', '68', '1');
INSERT INTO `menu` VALUES ('35', '梁湖风干鲫鱼', '36', '2');
INSERT INTO `menu` VALUES ('25', '口味鱼头', '78', '2');
INSERT INTO `menu` VALUES ('32', '苏州东坡肉', '68', '1');
INSERT INTO `menu` VALUES ('33', '珍珠南瓜元', '28', '1');
INSERT INTO `menu` VALUES ('33', '清汤面', '16', '1');
INSERT INTO `menu` VALUES ('33', '扬州炒饭', '16', '1');
INSERT INTO `menu` VALUES ('35', '口味鱼头', '78', '1');
INSERT INTO `menu` VALUES ('222', '苏州东坡肉', '68', '2');
INSERT INTO `menu` VALUES ('25', '酱油份蒸肉', '48', '1');
INSERT INTO `menu` VALUES ('25', '虾仁炖蛋', '28', '2');
INSERT INTO `menu` VALUES ('32', '虾仁炖蛋', '28', '1');
INSERT INTO `menu` VALUES ('33', '松茸菌土鸡汤', '35', '1');
INSERT INTO `menu` VALUES ('33', '海带排骨汤', '48', '2');
INSERT INTO `menu` VALUES ('33', '红薯丸子', '18', '1');
INSERT INTO `menu` VALUES ('33', '清蒸鲈鱼', '68', '1');
INSERT INTO `menu` VALUES ('35', '珍珠南瓜元', '28', '1');
INSERT INTO `menu` VALUES ('35', '酱油份蒸肉', '48', '1');
INSERT INTO `menu` VALUES ('43', '清蒸桂鱼', '108', '2');
INSERT INTO `menu` VALUES ('43', '苏州东坡肉', '68', '1');
INSERT INTO `menu` VALUES ('43', '清蒸桂鱼', '108', '2');
INSERT INTO `menu` VALUES ('43', '苏州东坡肉', '68', '1');
INSERT INTO `menu` VALUES ('43', '口味鱼头', '78', '2');
INSERT INTO `menu` VALUES ('43', '苏州东坡肉', '68', '1');
INSERT INTO `menu` VALUES ('43', '酱油份蒸肉', '48', '1');

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `RESERVENUMBER` int(11) NOT NULL DEFAULT '0',
  `DISKID` varchar(50) DEFAULT NULL,
  `CUSTNAME` varchar(50) DEFAULT NULL,
  `CUSTPHONE` varchar(50) DEFAULT NULL,
  `RESERVETIME` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`RESERVENUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserve
-- ----------------------------
INSERT INTO `reserve` VALUES ('5', '七位', '武器', '我', '2022-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('9', '10', '陈与', '18725632541', '2022-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('11', '我', '去', '武器', '2022-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('12', '七位', '武器', '七位', '2022-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('13', null, null, null, '2022-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('14', '我', '我', '我', '2022-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('31', '12', '22', '22', '2026-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('35', '33', '22', '22', '2026-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('36', '1', null, null, '2027-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('38', '七位', '七位', '七位', '2022-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('40', '七位', '七位', '七位', '2022-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('41', '1', null, null, '2022-08-20 17:00:00');
INSERT INTO `reserve` VALUES ('42', '1', 'we', 'werqwrd', '2018-01-04 15:16:16');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `project` varchar(20) NOT NULL,
  `grade` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'test', 'chinese', '30');
INSERT INTO `test` VALUES ('2', 'test', 'math', '15');
INSERT INTO `test` VALUES ('3', 'test', 'english', '20');
INSERT INTO `test` VALUES ('4', 'test', 'science', '25');
INSERT INTO `test` VALUES ('5', 'test', 'technology', '10');

-- ----------------------------
-- Table structure for turnover
-- ----------------------------
DROP TABLE IF EXISTS `turnover`;
CREATE TABLE `turnover` (
  `DATES` datetime DEFAULT CURRENT_TIMESTAMP,
  `MONEY` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of turnover
-- ----------------------------
INSERT INTO `turnover` VALUES ('2016-01-01 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-01-02 00:00:00', '600');
INSERT INTO `turnover` VALUES ('2016-01-03 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2016-01-04 00:00:00', '630');
INSERT INTO `turnover` VALUES ('2016-01-05 00:00:00', '440');
INSERT INTO `turnover` VALUES ('2016-01-06 00:00:00', '560');
INSERT INTO `turnover` VALUES ('2016-01-07 00:00:00', '470');
INSERT INTO `turnover` VALUES ('2016-01-08 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-01-09 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2016-01-10 00:00:00', '440');
INSERT INTO `turnover` VALUES ('2016-02-01 00:00:00', '420');
INSERT INTO `turnover` VALUES ('2016-02-02 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-02-03 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-02-04 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-02-05 00:00:00', '330');
INSERT INTO `turnover` VALUES ('2016-02-06 00:00:00', '330');
INSERT INTO `turnover` VALUES ('2016-02-07 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-02-08 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-02-09 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-02-10 00:00:00', '470');
INSERT INTO `turnover` VALUES ('2017-01-01 00:00:00', '322');
INSERT INTO `turnover` VALUES ('2017-01-02 00:00:00', '322');
INSERT INTO `turnover` VALUES ('2017-01-03 00:00:00', '310');
INSERT INTO `turnover` VALUES ('2017-01-04 00:00:00', '212');
INSERT INTO `turnover` VALUES ('2017-01-05 00:00:00', '310');
INSERT INTO `turnover` VALUES ('2016-01-11 00:00:00', '470');
INSERT INTO `turnover` VALUES ('2016-01-12 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-01-13 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-01-14 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2016-01-15 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-01-16 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2016-01-17 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2016-01-18 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-01-19 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-01-20 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-01-21 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2016-01-22 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2016-01-23 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-01-24 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2016-01-25 00:00:00', '470');
INSERT INTO `turnover` VALUES ('2016-01-26 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2016-01-27 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2016-01-28 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-01-29 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-01-30 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-01-31 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-02-11 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-02-12 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-02-13 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-02-14 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2016-02-15 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-02-16 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2016-02-17 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-02-18 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2016-02-19 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2016-02-20 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2016-02-21 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2016-02-22 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-02-23 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-02-24 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2016-02-25 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2016-02-26 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-02-27 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-02-28 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2016-02-29 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2016-02-11 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-02-12 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-02-13 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-02-14 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2016-02-15 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-02-16 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2016-02-17 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-02-18 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2016-02-19 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2016-02-20 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2016-02-21 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2016-02-22 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-02-23 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-02-24 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2016-02-25 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2016-02-26 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-02-27 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-02-28 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2016-02-29 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2017-01-06 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-01-07 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2017-01-08 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2017-01-09 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2017-01-10 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2017-01-11 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2017-01-12 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2017-01-13 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2017-01-14 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2017-01-15 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2017-01-16 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-01-17 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2017-01-18 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2017-01-19 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2017-01-20 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2017-01-21 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2017-01-22 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2017-01-23 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2017-01-24 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-01-25 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-01-26 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-01-27 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2017-01-28 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2017-01-29 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2017-01-30 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2017-01-31 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2017-02-01 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2017-02-02 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-02-03 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2017-02-04 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-02-05 00:00:00', '420');
INSERT INTO `turnover` VALUES ('2017-02-06 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-02-07 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-02-08 00:00:00', '470');
INSERT INTO `turnover` VALUES ('2017-02-09 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-02-10 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2017-02-11 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-02-12 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-02-13 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2017-02-14 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-02-15 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2017-02-16 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-02-17 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2017-02-18 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-02-19 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2017-02-20 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-02-21 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2017-02-22 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2017-02-23 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2017-02-24 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-02-25 00:00:00', '480');
INSERT INTO `turnover` VALUES ('2017-02-26 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-02-27 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2017-02-28 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2017-03-01 00:00:00', '440');
INSERT INTO `turnover` VALUES ('2017-03-02 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2017-03-03 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2017-03-04 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2017-03-05 00:00:00', '420');
INSERT INTO `turnover` VALUES ('2017-03-06 00:00:00', '430');
INSERT INTO `turnover` VALUES ('2017-03-07 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2017-03-08 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2017-03-09 00:00:00', '450');
INSERT INTO `turnover` VALUES ('2017-03-10 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2017-03-11 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2017-03-12 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2017-03-13 00:00:00', '570');
INSERT INTO `turnover` VALUES ('2017-03-14 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2017-03-15 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-03-16 00:00:00', '430');
INSERT INTO `turnover` VALUES ('2017-03-17 00:00:00', '560');
INSERT INTO `turnover` VALUES ('2017-03-18 00:00:00', '450');
INSERT INTO `turnover` VALUES ('2017-03-19 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2017-03-20 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2017-03-21 00:00:00', '570');
INSERT INTO `turnover` VALUES ('2017-03-22 00:00:00', '580');
INSERT INTO `turnover` VALUES ('2017-03-23 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2017-03-24 00:00:00', '440');
INSERT INTO `turnover` VALUES ('2017-03-25 00:00:00', '450');
INSERT INTO `turnover` VALUES ('2017-03-26 00:00:00', '560');
INSERT INTO `turnover` VALUES ('2017-03-27 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2017-03-28 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2017-03-29 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2017-03-30 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2017-03-31 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-03-01 00:00:00', '440');
INSERT INTO `turnover` VALUES ('2016-03-02 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-03-03 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2016-03-04 00:00:00', '510');
INSERT INTO `turnover` VALUES ('2016-03-05 00:00:00', '420');
INSERT INTO `turnover` VALUES ('2016-03-06 00:00:00', '430');
INSERT INTO `turnover` VALUES ('2016-03-07 00:00:00', '540');
INSERT INTO `turnover` VALUES ('2016-03-08 00:00:00', '490');
INSERT INTO `turnover` VALUES ('2016-03-09 00:00:00', '450');
INSERT INTO `turnover` VALUES ('2016-03-10 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2016-03-11 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2016-03-12 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-03-13 00:00:00', '570');
INSERT INTO `turnover` VALUES ('2016-03-14 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-03-15 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-03-16 00:00:00', '430');
INSERT INTO `turnover` VALUES ('2016-03-17 00:00:00', '560');
INSERT INTO `turnover` VALUES ('2016-03-18 00:00:00', '450');
INSERT INTO `turnover` VALUES ('2016-03-19 00:00:00', '460');
INSERT INTO `turnover` VALUES ('2016-03-20 00:00:00', '500');
INSERT INTO `turnover` VALUES ('2016-03-21 00:00:00', '570');
INSERT INTO `turnover` VALUES ('2016-03-22 00:00:00', '580');
INSERT INTO `turnover` VALUES ('2016-03-23 00:00:00', '550');
INSERT INTO `turnover` VALUES ('2016-03-24 00:00:00', '440');
INSERT INTO `turnover` VALUES ('2016-03-25 00:00:00', '450');
INSERT INTO `turnover` VALUES ('2016-03-26 00:00:00', '560');
INSERT INTO `turnover` VALUES ('2016-03-27 00:00:00', '520');
INSERT INTO `turnover` VALUES ('2016-03-28 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-03-29 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-03-30 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2016-03-31 00:00:00', '530');
INSERT INTO `turnover` VALUES ('2018-01-10 19:21:39', '0');
INSERT INTO `turnover` VALUES ('2018-01-10 19:21:54', '0');
INSERT INTO `turnover` VALUES ('2018-01-10 19:24:25', '0');
INSERT INTO `turnover` VALUES ('2018-01-10 20:11:45', '568');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `USERID` int(11) NOT NULL,
  `USERNAME` varchar(32) DEFAULT NULL,
  `USERSEX` varchar(32) DEFAULT NULL,
  `USERAGE` int(11) DEFAULT NULL,
  `USERPASSWORD` varchar(64) DEFAULT NULL,
  `USERPOSITION` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '黄雪薇', '女', '50', '111', '经理');
INSERT INTO `users` VALUES ('2', '兰彪', '男', '20', '111', '经理');
INSERT INTO `users` VALUES ('3', '孔令良', '男', '30', '111', '主管');
INSERT INTO `users` VALUES ('4', '乔德拴', '男', '34', '111', '厨师');
INSERT INTO `users` VALUES ('5', '党增城', '男', '42', '111', '帮工');
INSERT INTO `users` VALUES ('6', '向泰稳', '男', '25', '111', '扫地');
INSERT INTO `users` VALUES ('7', '李壮', '男', '14', '111', '洗菜');
INSERT INTO `users` VALUES ('8', '任磊', '男', '45', '111', '端盘');
INSERT INTO `users` VALUES ('9', '刘得生', '男', '42', '111', '切菜');
INSERT INTO `users` VALUES ('10', '张士现', '男', '42', '111', '保安');
INSERT INTO `users` VALUES ('11', '余宙', '男', '55', '111', '保安');
INSERT INTO `users` VALUES ('12', '王大伟', '男', '33', '111', '厨师');
INSERT INTO `users` VALUES ('13', '吕浩', '男', '27', '111', '端盘');
INSERT INTO `users` VALUES ('14', '付超', '男', '53', '111', '厨师');
INSERT INTO `users` VALUES ('15', '张青阳', '男', '47', '111', '采购');
INSERT INTO `users` VALUES ('16', '宋彩', '女', '22', '111', '收银员');
INSERT INTO `users` VALUES ('17', '王云棋', '女', '25', '111', '收银员');
INSERT INTO `users` VALUES ('18', '刘霏雯', '女', '29', '111', '领班');
INSERT INTO `users` VALUES ('19', '张小花', '女', '56', '111', '保洁');
