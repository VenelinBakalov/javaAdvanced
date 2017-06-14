SELECT e.`employee_id`, e.`first_name`, e.`salary`, d.`name` AS `department_name`
FROM `employees` AS e
INNER JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
	AND e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;