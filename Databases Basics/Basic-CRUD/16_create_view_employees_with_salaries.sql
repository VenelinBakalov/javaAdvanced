CREATE VIEW `v_employees_salaries` AS
	SELECT `first_name`, `last_name`, `salary` FROM `employees`;
	
SELECT * FROM `v_employees_salaries`;