## Working but in judge requires 2 spaces when middle name is null...
##CREATE VIEW `v_employees_job_titles` AS
##	SELECT IF(`middle_name` IS NULL, 
##		CONCAT(`first_name`, ' ', `last_name`),
##		CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`)) AS `full_name`,
##		`job_title`
##	FROM `employees`;

CREATE VIEW `v_employees_job_titles` AS
	SELECT IF(`middle_name` IS NULL,
	CONCAT(`first_name`, '  ', `last_name`),
	CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`)) AS `full_name`,
	`job_title`
	FROM `employees`;
	