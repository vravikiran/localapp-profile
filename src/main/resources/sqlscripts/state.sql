-- localapp.state definition

CREATE TABLE `state` (
  `state_id` bigint(20) NOT NULL,
  `state` varchar(255) NOT NULL,
  `country_id` bigint(20) NOT NULL,
  PRIMARY KEY (`state_id`,`country_id`),
  KEY `state` (`country_id`),
  CONSTRAINT `state_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;