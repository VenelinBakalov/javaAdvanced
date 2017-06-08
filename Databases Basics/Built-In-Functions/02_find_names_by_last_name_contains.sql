SELECT e.`first_name`, e.`last_name`
FROM `employees` AS e
WHERE LOCATE('EI', UPPER(`last_name`)) > 0;

SELECT e.`first_name`, e.`last_name`
FROM `employees` AS e
WHERE `last_name` LIKE '%ei%';