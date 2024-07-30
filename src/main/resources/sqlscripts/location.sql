-- localapp.location definition

CREATE TABLE `location` (
  `location_id` bigint(20) NOT NULL,
  `location` varchar(255) NOT NULL,
  `state_id` bigint(20) NOT NULL,
  `country_id` bigint(20) NOT NULL,
  PRIMARY KEY (`location_id`,`state_id`,`country_id`),
  KEY `country_id` (`country_id`),
  KEY `state_id` (`state_id`,`country_id`),
  CONSTRAINT `location_ibfk_1` FOREIGN KEY (`state_id`, `country_id`) REFERENCES `state` (`state_id`, `country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;