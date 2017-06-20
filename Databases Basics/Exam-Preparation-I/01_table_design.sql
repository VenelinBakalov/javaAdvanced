CREATE DATABASE `airport_management_system`;

USE `airport_management_system`;

CREATE TABLE `towns`
(
	`town_id` INT,
	`town_name` VARCHAR(30) NOT NULL,
	CONSTRAINT `pk_towns` PRIMARY KEY (`town_id`)
);

CREATE TABLE `airports`
(
	`airport_id` INT,
	`airport_name` VARCHAR(50) NOT NULL,
	`town_id` INT,
	CONSTRAINT `pk_airports` PRIMARY KEY (`airport_id`),
	CONSTRAINT `fk_airports_towns` FOREIGN KEY (`town_id`) REFERENCES `towns` (`town_id`)
);

CREATE TABLE `airlines`
(
	`airline_id` INT,
	`airline_name` VARCHAR(30) NOT NULL,
	`nationality` VARCHAR(30) NOT NULL,
	`rating` INT DEFAULT 0,
	CONSTRAINT `pk_airlines` PRIMARY KEY (`airline_id`)
);

CREATE TABLE `customers`
(
	`customer_id` INT,
	`first_name` VARCHAR(20) NOT NULL,
	`last_name` VARCHAR(20) NOT NULL,
	`date_of_birth` DATE NOT NULL,
	`gender` VARCHAR(1) NOT NULL,
	`home_town_id` INT,
	CONSTRAINT `pk_customers` PRIMARY KEY (`customer_id`),
	CONSTRAINT `fk_customers_towns` FOREIGN KEY (`home_town_id`) REFERENCES `towns` (`town_id`)
);

CREATE TABLE `flights`
(
	`flight_id` INT AUTO_INCREMENT,
	`departure_time` DATETIME NOT NULL,
	`arrival_time` DATETIME NOT NULL,
	`status` VARCHAR(9) NOT NULL,
	`origin_airport_id` INT,
	`destination_airport_id` INT,
	`airline_id` INT,
	CONSTRAINT `pk_flights` PRIMARY KEY (`flight_id`),
	CONSTRAINT `fk_flights_airports_origin_airport` FOREIGN KEY (`origin_airport_id`)
		REFERENCES `airports` (`airport_id`),
	CONSTRAINT `fk_flights_airports_destination_airport` FOREIGN KEY (`destination_airport_id`)
		REFERENCES `airports` (`airport_id`),
	CONSTRAINT `fk_flights_airlines` FOREIGN KEY (`airline_id`) REFERENCES `airlines` (`airline_id`)
);

CREATE TABLE `tickets`
(
	`ticket_id` INT AUTO_INCREMENT,
	`price` DECIMAL(8,2) NOT NULL,
	`class` VARCHAR(6) NOT NULL,
	`seat` VARCHAR(5) NOT NULL,
	`customer_id` INT,
	`flight_id` INT,
	CONSTRAINT `pk_tickets` PRIMARY KEY (`ticket_id`),
	CONSTRAINT `fk_tickets_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
	CONSTRAINT `fk_tickets_flights` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`flight_id`)
);