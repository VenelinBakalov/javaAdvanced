CREATE DATABASE `car_rental`;

USE `car_rental`;

CREATE TABLE `categories`
( 
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`category` VARCHAR(50) NOT NULL,
	`daily_rate` DOUBLE(10,2) NOT NULL,
	`weekly_rate` DOUBLE(10,2) NOT NULL,
	`monthly_rate` DOUBLE(10,2) NOT NULL,
	`weekend_rate` DOUBLE(10,2) NOT NULL
);

CREATE TABLE `cars`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`plate_number` VARCHAR(50) NOT NULL,
	`make` VARCHAR(50) NOT NULL,
	`model` VARCHAR(50) NOT NULL,
	`car_year` YEAR NOT NULL,
	`category_id` INT NOT NULL,
	`doors` INT(1) NOT NULL,
	`picture` BLOB,
	`car_condition` TEXT,
	`available` BOOL
);

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
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`driver_licence_number` INT NOT NULL,
	`full_name` VARCHAR(50) NOT NULL,
	`address` VARCHAR(50),
	`city` VARCHAR(50),
	`zip_code` INT,
	`notes` TEXT
);

CREATE TABLE `rental_orders`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`employee_id` INT NOT NULL,
	`customer_id` INT NOT NULL,
	`car_id` INT NOT NULL,
	`car_condition` TEXT,
	`tank_level` DOUBLE NOT NULL,
	`kilometrage_start` DOUBLE NOT NULL,
	`kilometrage_end` DOUBLE,
	`total_kilometrage` DOUBLE,
	`start_date` DATE NOT NULL,
	`end_date` DATE,
	`total_days` INT,
	`rate_applied` DOUBLE NOT NULL,
	`tax_rate` DOUBLE NOT NULL,
	`order_status` VARCHAR(50) NOT NULL,
	`notes` TEXT
);

INSERT INTO `categories` (`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`)
VALUES ('fast', 400, 1, 2, 3), ('very fast', 500, 1, 2, 3), ('dead fast', 100, 1, 2, 3);

INSERT INTO `cars` (`plate_number`, `make`, `model`, `car_year`,`category_id`, `doors`)
VALUES ('2323CA', 'mercedes', 'G63', 2005, 1,3), ('we78sd', 'mercedes', 'G63', 2005, 1,4), ('SD4949WE', 'mercedes', 'G63', 2005, 1,3);

INSERT INTO `employees` (`first_name`, `last_name`, `title`)
VALUES ('pesho', 'peshev', 'dude'), ('gosho', 'goshev', 'drunk'), ('ivan', 'ivanov', 'sensey');

INSERT INTO `customers` (`driver_licence_number`, `full_name`)
VALUES (123456, 'pesho peshev'), (456789, 'gosho goshev'), (123456789, 'ivan ivanov');

INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`, 
`tank_level`, `kilometrage_start`, `start_date`, `rate_applied`, `tax_rate`, 
`order_status`)
VALUES (1, 2, 3, 34, 55, '1999/06/05', 55.5, 12, 'tegav'),
(2, 5, 6, 34, 55, '1999/06/05', 55.5, 12, 'good'),
(3, 4, 7, 34, 55, '1999/06/05', 55.5, 12, 'bad');