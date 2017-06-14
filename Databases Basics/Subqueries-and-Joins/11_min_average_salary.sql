SELECT MIN(avg_salaries.avg_salary) AS `min_average_salary`
FROM (SELECT AVG(e.salary) as `avg_salary`
FROM `employees` AS e
GROUP BY e.department_id) AS `avg_salaries`;