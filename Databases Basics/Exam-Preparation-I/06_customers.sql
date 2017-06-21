SELECT c.customer_id, CONCAT_WS(' ', c.first_name, c.last_name) AS `full_name`, c.gender
FROM `customers` AS c
ORDER BY full_name ASC, c.customer_id ASC;