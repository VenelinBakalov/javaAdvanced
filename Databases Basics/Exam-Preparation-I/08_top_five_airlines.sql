SELECT a.airline_id, a.airline_name, a.nationality, a.rating
FROM `airlines` AS a
WHERE a.airline_id IN (
	SELECT f.airline_id FROM `flights` AS f)
ORDER BY a.rating DESC, a.airline_id ASC
LIMIT 5;