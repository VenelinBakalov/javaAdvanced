CREATE TABLE `users`
(
	`id` INT UNIQUE AUTO_INCREMENT,
	`username` CHAR(30) UNIQUE NOT NULL,
	`password` CHAR(26) NOT NULL,
	`profile_picture` BLOB(900),
	`last_login_time` DATETIME,
	`is_deleted` BOOL
);

ALTER TABLE `users`
ADD CONSTRAINT `pk_id` PRIMARY KEY (`id`);

INSERT INTO `users` (`username`, `password`)
VALUES ('Gosho', 'Pesho'), ('Pesho', 'Gosho'), ('Vui', 'Tui'), ('Kat', 'Stane'),
('VseTui', 'Stava');