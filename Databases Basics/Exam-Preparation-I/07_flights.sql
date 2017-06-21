SELECT f.flight_id, f.departure_time, f.arrival_time
FROM `flights` AS f
WHERE f.`status` = 'Delayed'
ORDER BY f.flight_id ASC;