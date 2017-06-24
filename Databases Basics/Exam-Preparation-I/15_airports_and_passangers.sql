SELECT a.airport_id, a.airport_name, COUNT(t.ticket_id) AS `passengers`
FROM `airports` AS a
INNER JOIN `flights` AS f
ON a.airport_id = f.origin_airport_id
INNER JOIN `tickets` AS t
ON f.flight_id = t.flight_id
	AND f.`status` = 'Departing'
GROUP BY a.airport_id, a.airport_name
HAVING `passengers` != 0
ORDER BY a.airport_id ASC;