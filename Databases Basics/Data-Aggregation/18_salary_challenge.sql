SELECT e.`first_name`, e.`last_name`, e.`department_id`
FROM
	(SELECT e.department_id, AVG(e.salary) AS avg_salary
	FROM `employees` AS e
	GROUP BY e.department_id) AS `departments_avg_salary`, `employees` AS e
WHERE e.department_id = departments_avg_salary.department_id
	AND e.`salary` > departments_avg_salary.avg_salary
ORDER BY e.department_id ASC
LIMIT 10;