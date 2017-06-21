SELECT * FROM
(SELECT f.flight_id, f.departure_time, f.arrival_time, a.airport_name AS `origin`, ad.airport_name AS `destination`
FROM `flights` AS f
INNER JOIN `airports` AS a
ON f.origin_airport_id = a.airport_id
INNER JOIN `airports` AS ad
ON f.destination_airport_id = ad.airport_id
WHERE f.`status` = 'Departing'
ORDER BY f.departure_time DESC
LIMIT 5) AS last_five_flights
ORDER BY last_five_flights.departure_time ASC, last_five_flights.flight_id ASC;