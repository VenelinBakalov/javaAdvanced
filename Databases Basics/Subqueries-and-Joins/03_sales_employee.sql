SELECT e.`employee_id`, e.`first_name`, e.`last_name`, d.`name`
FROM `employees` AS e
INNER JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
	AND d.`name` = 'Sales'
ORDER BY e.`employee_id` DESC;