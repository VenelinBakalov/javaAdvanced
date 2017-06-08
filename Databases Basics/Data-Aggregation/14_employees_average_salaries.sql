CREATE TABLE `average_salaries`
SELECT * FROM `employees`
WHERE `salary` > 30000;

DELETE FROM `average_salaries`
WHERE `manager_id`=42;

UPDATE `average_salaries`
	SET `salary` = `salary` + 5000
	WHERE `department_id`=1;
	
SELECT `department_id`, AVG(`salary`) AS 'avg_salary'
FROM `average_salaries`
GROUP BY `department_id`
ORDER BY `department_id` ASC;