# --------------------------------------------------------
# Host:                         localhost
# Database:                     cloudblog
# Server version:               5.1.46-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2010-10-24 11:10:09
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for cloudblog
DROP DATABASE IF EXISTS `cloudblog`;
CREATE DATABASE IF NOT EXISTS `cloudblog` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cloudblog`;


# Dumping structure for table cloudblog.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT '0',
  `path` varchar(200) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_category` (`path`,`rank`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Dumping data for table cloudblog.category: 0 rows
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


# Dumping structure for table cloudblog.device_log
DROP TABLE IF EXISTS `device_log`;
CREATE TABLE IF NOT EXISTS `device_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `session_id` varchar(100) DEFAULT NULL,
  `device_id` varchar(100) DEFAULT NULL,
  `device_name` varchar(50) DEFAULT NULL,
  `device_system` varchar(50) DEFAULT NULL,
  `action` int(11) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `INDEX_devicelog` (`session_id`,`device_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

# Dumping data for table cloudblog.device_log: 6 rows
/*!40000 ALTER TABLE `device_log` DISABLE KEYS */;
INSERT INTO `device_log` (`id`, `session_id`, `device_id`, `device_name`, `device_system`, `action`, `update_time`) VALUES (1, '69DBB2CEF3E2ED26EFD5C77076D9C7EE', 'SDK23LSDF89', 'nexus_one', 'android2.2', 1, NULL), (2, '69DBB2CEF3E2ED26EFD5C77076D9C7EE', 'SDK23LSDF89', 'nexus_one', 'android2.2', 2, NULL), (3, 'A0B7884CE93B58EF3FACEA1092891123', 'IMEI2938479382', 'HTCDesir', 'android2.2', 1, '2010-10-23 15:55:42'), (4, '59F873B3A022A326CCC4E11D35D21C2F', 'IMEI3294u9238', 'HTCwin7', 'win7', 1, '2010-10-23 15:58:23'), (5, '7CF43091C83C25A14AFF79B92652C291', 'IMEI3294u9238', 'HTCwin7', 'win7', 1, '2010-10-23 16:04:10'), (6, '34BCCAC5073B294A166DF709A223796B', 'IMEI3294u9238', 'HTCwin7', 'win7', 1, '2010-10-23 16:05:35');
/*!40000 ALTER TABLE `device_log` ENABLE KEYS */;


# Dumping structure for table cloudblog.image_news
DROP TABLE IF EXISTS `image_news`;
CREATE TABLE IF NOT EXISTS `image_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `provider_id` bigint(20) DEFAULT NULL,
  `tweet_id` varchar(45) DEFAULT NULL,
  `tweet_name` varchar(45) DEFAULT NULL,
  `tweet_header` varchar(45) DEFAULT NULL,
  `thumb_url` varchar(400) DEFAULT NULL,
  `orignal_url` varchar(400) DEFAULT NULL,
  `format` varchar(45) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `description` text,
  `read_count` bigint(20) DEFAULT NULL,
  `publish_count` bigint(20) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_provider` (`provider_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Dumping data for table cloudblog.image_news: 0 rows
/*!40000 ALTER TABLE `image_news` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_news` ENABLE KEYS */;


# Dumping structure for table cloudblog.news_category
DROP TABLE IF EXISTS `news_category`;
CREATE TABLE IF NOT EXISTS `news_category` (
  `news_type` int(11) NOT NULL,
  `news_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  UNIQUE KEY `PK_newsCategory` (`news_type`,`category_id`,`news_id`),
  KEY `FK_category` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='newstype: 1-text,2-image,3-video';

# Dumping data for table cloudblog.news_category: 0 rows
/*!40000 ALTER TABLE `news_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `news_category` ENABLE KEYS */;


# Dumping structure for table cloudblog.providers
DROP TABLE IF EXISTS `providers`;
CREATE TABLE IF NOT EXISTS `providers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) NOT NULL,
  `status` int(11) DEFAULT '1',
  `web_url` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `logo` varchar(200) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `rank_INDEX` (`rank`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

# Dumping data for table cloudblog.providers: 1 rows
/*!40000 ALTER TABLE `providers` DISABLE KEYS */;
INSERT INTO `providers` (`id`, `name`, `code`, `status`, `web_url`, `description`, `logo`, `rank`) VALUES (1, '新浪', 'SINA', 1, 'http://zhelazhela.com/api/', '新浪微薄', 'http://t.sina.com.cn/', 1);
/*!40000 ALTER TABLE `providers` ENABLE KEYS */;


# Dumping structure for table cloudblog.provider_user
DROP TABLE IF EXISTS `provider_user`;
CREATE TABLE IF NOT EXISTS `provider_user` (
  `provider_id` bigint(20) NOT NULL,
  `account` varchar(45) NOT NULL,
  `users_account` varchar(100) DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL,
  `token_secret` varchar(100) DEFAULT NULL,
  `token_more` varchar(200) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`provider_id`,`account`),
  KEY `INDEX_user` (`users_account`),
  KEY `FK_providerUser` (`users_account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Dumping data for table cloudblog.provider_user: 0 rows
/*!40000 ALTER TABLE `provider_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider_user` ENABLE KEYS */;


# Dumping structure for table cloudblog.text_news
DROP TABLE IF EXISTS `text_news`;
CREATE TABLE IF NOT EXISTS `text_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `provider_id` bigint(20) DEFAULT NULL,
  `tweet_id` varchar(45) DEFAULT NULL,
  `tweet_name` varchar(45) DEFAULT NULL,
  `tweet_header` varchar(45) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `description` text,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_provider` (`provider_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Dumping data for table cloudblog.text_news: 0 rows
/*!40000 ALTER TABLE `text_news` DISABLE KEYS */;
/*!40000 ALTER TABLE `text_news` ENABLE KEYS */;


# Dumping structure for table cloudblog.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `account` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `e_mail` varchar(200) DEFAULT NULL,
  `display_name` varchar(45) DEFAULT NULL,
  `header` varchar(100) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`account`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Dumping data for table cloudblog.users: 0 rows
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


# Dumping structure for table cloudblog.video_news
DROP TABLE IF EXISTS `video_news`;
CREATE TABLE IF NOT EXISTS `video_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `provider_id` bigint(20) DEFAULT NULL,
  `tweet_id` varchar(45) DEFAULT NULL,
  `tweet_name` varchar(45) DEFAULT NULL,
  `tweet_header` varchar(45) DEFAULT NULL,
  `preview` varchar(400) DEFAULT NULL,
  `url` varchar(400) DEFAULT NULL,
  `format` varchar(45) DEFAULT NULL,
  `time_length` int(11) DEFAULT NULL,
  `bit_rate` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `description` text,
  `read_count` bigint(20) DEFAULT NULL,
  `publish_count` bigint(20) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_provider` (`provider_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Dumping data for table cloudblog.video_news: 0 rows
/*!40000 ALTER TABLE `video_news` DISABLE KEYS */;
/*!40000 ALTER TABLE `video_news` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
