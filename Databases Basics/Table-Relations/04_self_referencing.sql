CREATE TABLE `teachers`
(
	`teacher_id` INT PRIMARY KEY,
	`name` VARCHAR(50) NOT NULL,
	`manager_id` INT,
	CONSTRAINT `fk_teachers` FOREIGN KEY (`manager_id`)
	REFERENCES `teachers` (`teacher_id`)
);

INSERT INTO `teachers` (`teacher_id`, `name`)
VALUES (101, 'John');

INSERT INTO `teachers` (`teacher_id`, `name`, `manager_id`)
VALUES (105, 'Mark', 101), (106, 'Greta', 101), (102, 'Maya', 106), (103, 'Silvia', 106), (104, 'Ted', 105);