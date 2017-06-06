SELECT `first_name`, `last_name`, `job_title`
FROM `employees` AS e
WHERE e.`salary` BETWEEN 20000 AND 30000;

SELECT `first_name`, `last_name`, `job_title`
FROM `employees` AS e
WHERE e.`salary` >= 20000 AND e.`salary` <= 30000;