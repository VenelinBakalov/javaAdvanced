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
		SET @origin = (SELECT a.airport_name FROM airports AS a
							WHERE a.airport_id = new.origin_airport_id);
		SET @destination = (SELECT a.airport_name FROM `airports` AS a
							WHERE a.airport_id = new.destination_airport_id);
		SET @passengers = (SELECT COUNT(*) FROM flights AS f
								 INNER JOIN tickets AS t ON f.flight_id = t.ticket_id);
		INSERT INTO `arrived_flights` (`flight_id`, `arrival_time`, `origin`, `destination`, `passengers`)
		VALUES (old.flight_id, new.arrival_time, origin, destination, passengers);

	END IF;
	
END $$

DELIMITER ;