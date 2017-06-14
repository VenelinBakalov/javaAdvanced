SELECT e.employee_id, e.first_name, m.employee_id AS `manager_id`, m.first_name AS `manager_name`
FROM `employees` AS e
INNER JOIN `employees` AS m
ON e.manager_id = m.employee_id
	AND m.employee_id IN (3, 7)
ORDER BY e.first_name ASC;
