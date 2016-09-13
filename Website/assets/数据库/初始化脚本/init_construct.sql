
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for CLICK_STATISTICS
-- ----------------------------
DROP TABLE IF EXISTS `CLICK_STATISTICS`;
CREATE TABLE `CLICK_STATISTICS` (
  `CLICK_ID` varchar(32) NOT NULL COMMENT '点击统计ID(自生成，uuid)',
  `CLICK_TYPE` varchar(8) DEFAULT NULL COMMENT '点击类型(1.进入老用户分享页面，2.老用户点击生成网址，3.用户点击进入分享页面，5.点击去开户',
  `CLICK_TIME` datetime DEFAULT NULL COMMENT '点击时间',
  PRIMARY KEY (`CLICK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='点击统计表';

-- ----------------------------
-- Table structure for MEMBER_INFO
-- ----------------------------
DROP TABLE IF EXISTS `MEMBER_INFO`;
CREATE TABLE `MEMBER_INFO` (
  `MEMBER_ID` varchar(32) NOT NULL COMMENT '会员单位ID',
  `MEMBER_NAME` varchar(128) DEFAULT NULL COMMENT '会员单位名称',
  `MEMBER_URL` varchar(256) DEFAULT NULL COMMENT '会员单位专属URL',
  `MEMBER_STATUS` varchar(8) DEFAULT NULL COMMENT '会员状态(N:正常 C:注销 D：冻结)',
  PRIMARY KEY (`MEMBER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员单位信息表';

-- ----------------------------
-- Table structure for SHARE_INFO
-- ----------------------------
DROP TABLE IF EXISTS `SHARE_INFO`;
CREATE TABLE SHARE_INFO
(
   SHARE_ID             VARCHAR(32) NOT NULL COMMENT '分享信息表（自生成，uuid）',
   SHARE_PHONE          VARCHAR(16) NOT NULL COMMENT '分享人手机号',
   SHARE_MEMBER_ID      VARCHAR(32) COMMENT '分享人所属会员单位ID',
   SHARE_ACCOUNT        VARCHAR(32) COMMENT '分享人开户的账号',
   SHARE_NAME           VARCHAR(32) COMMENT '分享人姓名',
   SHARE_URL            VARCHAR(256) COMMENT '分享的URL',
   SHARE_TIME           DATETIME COMMENT '分享时间(生成连接的时间)',
   PRIMARY KEY (SHARE_ID)
);

ALTER TABLE SHARE_INFO COMMENT '分享信息表';

-- ----------------------------
-- Table structure for SHARED_INFO
-- ----------------------------
DROP TABLE IF EXISTS `SHARED_INFO`;
CREATE TABLE `SHARED_INFO` (
  `SHARED_ID` varchar(32) NOT NULL COMMENT '被分享信息ID(自生成，uuid)',
  `SHARE_ID` varchar(32) DEFAULT NULL COMMENT '分享信息ID',
  `SHARED_PHONE` varchar(16) NOT NULL COMMENT '新用户手机号(被分享人)',
  `MEMBER_ID` varchar(32) NOT NULL COMMENT '所属会员单位',
  `SHARED_TIME` datetime DEFAULT NULL COMMENT '被分享时间',
  `OPEN_ACCOUNT_TIME` datetime DEFAULT NULL COMMENT '开户时间',
  `OPEN_ACCOUNT_STATUS` varchar(8) DEFAULT NULL COMMENT '开户状态',
  `SHARE_CHANNEL` varchar(8) DEFAULT NULL COMMENT '被分享渠道(1.微信，2.QQ，3.QQ空间，4.微博，5.其他)',
  `SIGN` varchar(128) DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`SHARED_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='被分享信息表';


commit;