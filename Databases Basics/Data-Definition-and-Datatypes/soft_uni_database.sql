CREATE DATABASE `soft_uni`;

USE `soft_uni`;

CREATE TABLE `towns`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `addresses`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`address_text` VARCHAR(200) NOT NULL,
	`town_id` INT NOT NULL,
	FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);

CREATE TABLE `departments`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `employees`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`first_name` VARCHAR(50) NOT NULL,
	`middle_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`job_title` VARCHAR(50) NOT NULL,
	`department_id` INT NOT NULL,
	`hire_date` DATE NOT NULL,
	`salary` DOUBLE(10,2) NOT NULL,
	`address_id` INT NOT NULL,
	FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`),
	FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
);

