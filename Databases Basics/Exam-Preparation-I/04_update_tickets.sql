UPDATE `tickets` AS t
INNER JOIN `flights` AS f 
ON t.flight_id = f.flight_id
SET `price` = `price` * 1.2
WHERE f.flight_id = 
	(SELECT a.airline_id
	FROM `airlines` AS a
	GROUP BY a.airline_id
	HAVING MAX(a.rating)
	LIMIT 1);