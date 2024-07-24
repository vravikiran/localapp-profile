CREATE TABLE `location` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) NOT NULL,
  `state_id` bigint(20) NOT NULL,
  `country_id` bigint(20) NOT NULL,
  PRIMARY KEY (`location_id`),
  KEY `location` (`state_id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `location_ibfk_1` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`),
  CONSTRAINT `location_ibfk_2` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
)