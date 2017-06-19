DELIMITER $$

CREATE FUNCTION udf_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(10)
BEGIN
	DECLARE `salary_level` VARCHAR(10);
	
	IF (salary < 30000) THEN
	SET `salary_level` := 'Low';
	ELSEIF (salary BETWEEN 30000 AND 50000) THEN
	SET salary_level := 'Average';
	ELSE
	SET salary_level := 'High';
	END IF;
	RETURN salary_level;
END $$

DELIMITER ;

SELECT e.salary, udf_get_salary_level(e.salary) AS `salary_level`
FROM `employees` AS e;