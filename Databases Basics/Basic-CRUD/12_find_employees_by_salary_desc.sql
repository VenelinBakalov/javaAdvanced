SELECT
	`first_name`, `last_name`, `salary`
FROM
	`employees` AS e
WHERE
	e.`salary` > 50000
ORDER BY
	e.`salary` DESC;