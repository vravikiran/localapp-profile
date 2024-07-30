-- localapp.`user` definition

CREATE TABLE `user` (
  `mobile_no` bigint(20) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `aadhar_number` bigint(20) NOT NULL,
  `is_email_verified` tinyint(1) DEFAULT '0',
  `is_aadhar_verified` tinyint(1) DEFAULT '0',
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`mobile_no`),
  KEY `fk_address_id` (`address_id`),
  CONSTRAINT `fk_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;