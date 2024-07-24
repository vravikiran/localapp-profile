CREATE TABLE `state` (
  `state_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `state` varchar(255) NOT NULL,
  `country_id` bigint(20) NOT NULL,
  PRIMARY KEY (`state_id`),
  KEY `state` (`country_id`),
  CONSTRAINT `state_ibfk_1` FOREIGN KEY (country_id) REFERENCES `country` (country_id)