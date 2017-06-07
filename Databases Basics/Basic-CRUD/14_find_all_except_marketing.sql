SELECT `first_name`, `last_name`
FROM `employees` AS e
WHERE NOT e.`department_id`=4;