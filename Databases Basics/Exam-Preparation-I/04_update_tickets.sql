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

UPDATE tickets AS t
SET t.price = t.price * 1.5
WHERE t.flight_id IN (	
	SELECT f.flight_id
	FROM flights AS f
	INNER JOIN airlines AS a
	ON f.airline_id = a.airline_id
	WHERE a.rating = (SELECT MAX(a.rating) FROM airlines AS a));