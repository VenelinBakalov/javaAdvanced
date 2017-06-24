CREATE TABLE `users`
(
	`id` INT,
	`username` VARCHAR(30) NOT NULL UNIQUE,
	`password` VARCHAR(30) NOT NULL,
	`email` VARCHAR(50),
	CONSTRAINT `pk_users` PRIMARY KEY (`id`)
);

CREATE TABLE `categories`
(
	`id` INT,
	`name` VARCHAR(50) NOT NULL,
	`parent_id` INT,
	CONSTRAINT `pk_categories` PRIMARY KEY (`id`),
	CONSTRAINT `fk_categories_categories` FOREIGN KEY (`parent_id`)
	REFERENCES `categories` (`id`)
);

CREATE TABLE `contests`
(
	`id` INT,
	`name` VARCHAR(50) NOT NULL,
	`category_id` INT,
	CONSTRAINT `pk_contests` PRIMARY KEY (`id`),
	CONSTRAINT `fk_contests_categories` FOREIGN KEY (`category_id`)
	REFERENCES `categories` (`id`)
);

CREATE TABLE `problems`
(
	`id` INT,
	`name` VARCHAR(100) NOT NULL,
	`points` INT NOT NULL,
	`tests` INT DEFAULT 0,
	`contest_id` INT,
	CONSTRAINT `pk_problems` PRIMARY KEY (`id`),
	CONSTRAINT `fk_problems_contests` FOREIGN KEY (`contest_id`)
	REFERENCES `contests` (`id`)
);

CREATE TABLE `submissions`
(
	`id` INT AUTO_INCREMENT,
	`passed_tests` INT NOT NULL,
	`problem_id` INT,
	`user_id` INT,
	CONSTRAINT `pk_submissions` PRIMARY KEY (`id`),
	CONSTRAINT `fk_submissions_problems` FOREIGN KEY (`problem_id`)
	REFERENCES `problems` (`id`),
	CONSTRAINT `fk_submissions_users` FOREIGN KEY (`user_id`)
	REFERENCES `users` (`id`)
);

CREATE TABLE `users_contests`
(
	`user_id` INT,
	`contest_id` INT,
	CONSTRAINT `pk_users_contests` PRIMARY KEY (`user_id`, `contest_id`),
	CONSTRAINT `fk_users_contests_users` FOREIGN KEY (`user_id`)
	REFERENCES `users` (`id`),
	CONSTRAINT `fk_users_contests_contests` FOREIGN KEY (`contest_id`)
	REFERENCES `contests` (`id`)
);