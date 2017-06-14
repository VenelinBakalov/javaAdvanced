SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS `employee_name`,
		 CONCAT(m.first_name, ' ', m.last_name) AS `manager_name`,
		 d.name AS `department_name`
FROM `employees` AS e
INNER JOIN `employees` AS m
ON e.manager_id = m.employee_id
INNER JOIN `departments` AS d
ON e.department_id = d.department_id
ORDER BY e.employee_id ASC
LIMIT 5;