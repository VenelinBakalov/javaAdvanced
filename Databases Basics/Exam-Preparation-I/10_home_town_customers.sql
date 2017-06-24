SELECT DISTINCT c.customer_id, 
		CONCAT_WS(' ', c.first_name, c.last_name) AS `full_name`, 
		ts.town_name AS `home_town`
FROM `customers` AS c
INNER JOIN `tickets` AS t
ON c.customer_id = t.customer_id
INNER JOIN `flights` AS f
ON t.flight_id = f.flight_id
INNER JOIN `airports` AS a
ON f.origin_airport_id = a.airport_id
INNER JOIN `towns` AS ts
ON a.town_id = ts.town_id
	AND c.home_town_id = a.town_id
	AND f.`status` = 'Departing'
ORDER BY c.customer_id ASC;

# OR INNER JOIN towns AS ts ON c.home_town_id = ts.town_id
# AND c.home_town_id = a.town_id