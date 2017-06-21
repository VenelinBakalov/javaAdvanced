DELIMITER $$

CREATE TRIGGER tr_update_flight_status

BEFORE UPDATE
ON `flights`
FOR EACH ROW
BEGIN
		IF
		old.`status` NOT IN ('Cancelled', 'Arrived', 'Delayed')
		AND new.`status` = 'Arrived'
	THEN
		INSERT INTO `arrived_flights` (`flight_id`, `arrival_time`, `origin`, `destination`, `passengers`)
		SELECT old.`flight_id`, f.arrival_time, a_origin.airport_name, a_destination.airport_name, 
				 COUNT(t.ticket_id)
		FROM `flights` AS f
		INNER JOIN `airports` AS a_origin
		ON f.origin_airport_id = a_origin.airport_id
		INNER JOIN `airports` AS a_destination
		ON f.destination_airport_id = a_destination.airport_id
		INNER JOIN `tickets` AS t
		ON f.flight_id = t.flight_id
			AND f.flight_id = old.flight_id
		GROUP BY old.`flight_id`, f.arrival_time, a_origin.airport_name, a_destination.airport_name;
	END IF;
	
END $$

DELIMITER ;