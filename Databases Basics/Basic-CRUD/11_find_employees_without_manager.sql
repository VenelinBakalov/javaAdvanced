SELECT
	`first_name`, `last_name`
FROM
	`employees` AS e
WHERE
	e.`manager_id` IS NULL;