CREATE DATABASE `hotel`;

USE `hotel`;

CREATE TABLE `employees`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`title` VARCHAR(50) NOT NULL,
	`notes` TEXT
);

CREATE TABLE `customers`
(
	`account_number` INT AUTO_INCREMENT PRIMARY KEY,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`phone_number` INT NOT NULL,
	`emergency_name` VARCHAR(50),
	`emergency_number` INT,
	`notes` TEXT
);

CREATE TABLE `room_status`
(
	`room_status` VARCHAR(50) NOT NULL PRIMARY KEY,
	`notes` TEXT
);

CREATE TABLE `room_types`
(
	`room_type` VARCHAR(50) NOT NULL PRIMARY KEY,
	`notes` TEXT
);

CREATE TABLE `bed_types`
(
	`bed_type` VARCHAR(50) NOT NULL PRIMARY KEY,
	`notes` TEXT
);

CREATE TABLE `rooms`
(
	`room_number` INT NOT NULL PRIMARY KEY,
	`room_type` VARCHAR(50) NOT NULL,
	`bed_type` VARCHAR(50) NOT NULL,
	`rate` DOUBLE(10, 2) NOT NULL,
	`room_status` VARCHAR(50) NOT NULL,
	`notes` TEXT
);

CREATE TABLE `payments`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`employee_id` INT NOT NULL,
	`payment_date` DATE NOT NULL,
	`account_number` INT NOT NULL,
	`first_date_occupied` DATE NOT NULL,
	`last_date_occupied` DATE NOT NULL,
	`total_days` INT NOT NULL,
	`amount_charged` DOUBLE(10,2) NOT NULL,
	`tax_rate` DOUBLE(10,2) NOT NULL,
	`tax_amount` DOUBLE(10,2) NOT NULL,
	`payment_total` DOUBLE(10,2) NOT NULL,
	`notes` TEXT
);

CREATE TABLE `occupancies`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`employee_id` INT NOT NULL,
	`date_occupied` DATE NOT NULL,
	`account_number` INT NOT NULL,
	`room_number` INT NOT NULL,
	`rate_applied` DOUBLE(10,2) NOT NULL,
	`phone_charge` DOUBLE(10,2),
	`notes` TEXT
);

INSERT INTO `employees` (`first_name`, `last_name`, `title`)
VALUES ('pesho', 'peshev', 'dude'), ('ivan', 'ivanov', 'sensey'), ('venci', 'venkov', 'masta');

INSERT INTO `customers` (`first_name`, `last_name`, `phone_number`)
VALUES ('pesho', 'peshev', 0888867656), ('gosho', 'goshev', 0888867656), ('tegav', 'tegavenqk', 0888867656);

INSERT INTO `room_status` (`room_status`)
VALUES ('taken'), ('free'), ('it\'s complicated');

INSERT INTO `room_types` (`room_type`)
VALUES ('big'), ('small'), ('medium');

INSERT INTO `bed_types` (`bed_type`)
VALUES ('single'), ('double'), ('king');

INSERT INTO `rooms` (`room_number`, `room_type`, `bed_type`, `rate`, `room_status`)
VALUES (1, 'big', 'double', 5, 'free'), (2, 'big', 'double', 5, 'free'), (3, 'big', 'double', 5, 'free');

INSERT INTO `payments` (`employee_id`, `payment_date`, `account_number`,
`first_date_occupied`, `last_date_occupied`, `total_days`, `amount_charged`,
`tax_rate`, `tax_amount`, `payment_total`)
VALUES (1, '2000-12-04', 2, '2000-12-01', '2000-12-03', 2, 500, 100, 123, 500), (1, '2000-12-04', 2, '2000-12-01', '2000-12-03', 2, 500, 100, 123, 500), 
(1, '2000-12-04', 2, '2000-12-01', '2000-12-03', 2, 500, 100, 123, 500);

INSERT INTO `occupancies` (`employee_id`, `date_occupied`, `account_number`,
`room_number`, `rate_applied`)
VALUES (1, '2000-12-01', 2, 3, 5.5), (2, '2000-12-01', 2, 3, 5.5), (3, '2000-12-01', 2, 3, 5.5);
