SELECT e.employee_id, e.first_name, p.name
FROM `employees` AS e
INNER JOIN `employees_projects` AS ep
ON e.employee_id = ep.employee_id
	AND e.employee_id = 24
LEFT OUTER JOIN `projects` AS p
ON ep.project_id = p.project_id
	AND YEAR(p.start_date) < 2005
ORDER BY p.name ASC;