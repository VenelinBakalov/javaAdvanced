SELECT c.customer_id, CONCAT_WS(' ', c.first_name, c.last_name) AS `full_name`,
		 MAX(t.price) AS `ticket_price`, a.airport_name AS `destination`
FROM `customers` AS c
INNER JOIN `tickets` AS t
ON c.customer_id = t.customer_id
INNER JOIN `flights` AS f
ON t.flight_id = f.flight_id
	AND f.`status` = 'Delayed'
INNER JOIN `airports` AS a
ON f.destination_airport_id = a.airport_id
GROUP BY  c.customer_id, full_name
ORDER BY ticket_price DESC, c.customer_id ASC
LIMIT 3;