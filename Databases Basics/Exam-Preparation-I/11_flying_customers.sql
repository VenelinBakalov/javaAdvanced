SELECT DISTINCT c.customer_id, 
					CONCAT_WS(' ', c.first_name, c.last_name) AS `full_name`,
					2016 - YEAR(c.date_of_birth) AS `age`
FROM `customers` AS c
INNER JOIN `tickets` AS t
ON c.customer_id = t.customer_id
INNER JOIN `flights` AS f
ON t.flight_id = f.flight_id
	AND f.`status` = 'Departing'
ORDER BY age ASC, c.customer_id ASC;