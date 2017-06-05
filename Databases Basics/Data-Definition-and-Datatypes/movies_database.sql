CREATE DATABASE `movies`;

USE `movies`;

CREATE TABLE `directors`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`director_name` VARCHAR(50) NOT NULL,
	`notes` TEXT
);

CREATE TABLE `genres`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`genre_name` VARCHAR(50) NOT NULL,
	`notes` TEXT
);

CREATE TABLE `categories`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`category_name` VARCHAR(50) NOT NULL,
	`notes` TEXT
);

CREATE TABLE `movies`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`title` VARCHAR(50) NOT NULL,
	`director_id` INT NOT NULL,
	`copyright_year` YEAR NOT NULL,
	`length` DOUBLE (10,2) NOT NULL,
	`genre_id` INT NOT NULL,
	`category_id` INT NOT NULL,
	`rating` INT,
	`notes` TEXT
);

INSERT INTO `directors` (`director_name`)
VALUES ('gosho'), ('pesho'), ('vankata'), ('ridley scott'), ('enough');

INSERT INTO `genres` (`genre_name`)
VALUES ('horror'), ('fantasy'), ('thriler'), ('comedy'), ('soft uni');

INSERT INTO `categories` (`category_name`)
VALUES ('low budget'), ('i dont know'), ('need 3 more categories'), ('this is getting boring'),
('last one');

INSERT INTO `movies` (`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`)
VALUES ('Alien', '1', '2050', '2.20', '2', '3'), 
	('Predator', '5', '2050', '2.20', '4', '1'),
	('Alien vs Predator', '1', '2050', '2.20', '2', '3'),
	('Prometheus', '1', '2050', '2.20', '2', '3'),
	('Covenant', '1', '2050', '2.20', '2', '3');
	
ALTER TABLE `movies`
ADD CONSTRAINT `fk_movies_director` FOREIGN KEY (`director_id`)
REFERENCES `directors` (`id`),
ADD CONSTRAINT `fk_movies_genre` FOREIGN KEY (`genre_id`)
REFERENCES `genres` (`id`),
ADD CONSTRAINT `fk_movies_category` FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`);
