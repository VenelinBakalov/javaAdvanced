CREATE DATABASE `the_nerd_herd`;

USE `the_nerd_herd`;

CREATE TABLE `locations`
(
	`id` INT,
	`latitude` FLOAT,
	`longitude` FLOAT,
	CONSTRAINT `pk_locations` PRIMARY KEY (`id`)
);

CREATE TABLE `credentials`
(
	`id` INT,
	`email` VARCHAR(30),
	`password` VARCHAR(20),
	CONSTRAINT `pk_credentials` PRIMARY KEY (`id`)
);

CREATE TABLE `users`
(
	`id` INT,
	`nickname` VARCHAR(25),
	`gender` CHAR(1),
	`age` INT,
	`location_id` INT,
	`credential_id` INT UNIQUE,
	CONSTRAINT `pk_users` PRIMARY KEY (`id`),
	CONSTRAINT `fk_users_locations` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`),
	CONSTRAINT `fk_users_credentials` FOREIGN KEY (`credential_id`) REFERENCES `credentials` (`id`)
);

CREATE TABLE `chats`
(
	`id` INT,
	`title` VARCHAR(32),
	`start_date` DATE,
	`is_active` BIT,
	CONSTRAINT `pk_chats` PRIMARY KEY (`id`)
);

CREATE TABLE `messages`
(
	`id` INT AUTO_INCREMENT,
	`content` VARCHAR(200),
	`sent_on` DATE,
	`chat_id` INT,
	`user_id` INT,
	CONSTRAINT `pk_messages` PRIMARY KEY (`id`),
	CONSTRAINT `fk_messages_chats` FOREIGN KEY (`chat_id`) REFERENCES `chats` (`id`),
	CONSTRAINT `fk_messages_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `users_chats`
(
	`user_id` INT,
	`chat_id` INT,
	CONSTRAINT `pk_users_chats` PRIMARY KEY (`user_id`, `chat_id`),
	CONSTRAINT `fk_users_chats_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
	CONSTRAINT `fk_users_chats_chats` FOREIGN KEY (`chat_id`) REFERENCES `chats` (`id`)
); 
