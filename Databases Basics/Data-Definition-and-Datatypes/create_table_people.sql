CREATE TABLE `people`
(
	id INT AUTO_INCREMENT UNIQUE,
	name VARCHAR(200) NOT NULL,
	picture BLOB,
	height DOUBLE(10,2),
	weight DOUBLE(10,2),
	gender ENUM('f','m') NOT NULL,
	birthdate DATE NOT NULL,
	biography TEXT
);

INSERT INTO `people` (`name`, `gender`, `birthdate`)
VALUES ('Venelin', 'm', '2000-06-05'), 
('Daniela', 'f', '2000-06-05'), 
('Ivan', 'm', '2000-06-05'),
('Pesho', 'm', '2000-06-05'),
('Venci', 'm', '2000-06-05');