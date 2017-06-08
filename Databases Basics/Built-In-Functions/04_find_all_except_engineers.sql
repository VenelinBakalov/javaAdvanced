SELECT `first_name`, `last_name`
FROM `employees`
WHERE LOCATE('engineer', `job_title`) = 0;

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%';