CREATE DATABASE minions;

USE minions;

CREATE TABLE minions
(
	id INT,
	name VARCHAR(50),
	age INT
);

CREATE TABLE towns
(
	id INT,
	name VARCHAR(50)
);

ALTER TABLE minions
ADD CONSTRAINT pk_id
PRIMARY KEY (id);

ALTER TABLE towns
ADD CONSTRAINT pk_id
PRIMARY KEY (id);