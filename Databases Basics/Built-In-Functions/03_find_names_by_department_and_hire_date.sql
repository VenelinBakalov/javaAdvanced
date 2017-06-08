SELECT `first_name`
FROM `employees`
WHERE `department_id` IN(3, 10) 
	AND `hire_date` BETWEEN '1995/01/01' AND '2005/12/31';
	
SELECT `first_name`
FROM `employees`
WHERE `department_id` IN(3, 10) 
	AND EXTRACT(year FROM `hire_date`) BETWEEN 1995 AND 2005;