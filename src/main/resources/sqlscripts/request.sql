CREATE TABLE `request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) NOT NULL,
  `no_of_persons` int(4) NOT NULL,
  `is_room_required` tinyint(1) DEFAULT '0',
  `is_vehicle_required` tinyint(1) DEFAULT '0',
  `is_food_required` tinyint(1) DEFAULT '0',
  `places` varchar(255) NOT NULL,
  `traveller_id` bigint(20) NOT NULL,
  `traveller_name` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `plan_type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
)