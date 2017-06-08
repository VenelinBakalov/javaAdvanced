CREATE VIEW `v_employees_hired_after_2000` AS
	SELECT `first_name`, `last_name`
	FROM `employees`
	WHERE EXTRACT(year FROM `hire_date`) > 2000;
