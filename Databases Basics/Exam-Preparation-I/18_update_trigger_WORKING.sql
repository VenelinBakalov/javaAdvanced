DELIMITER $$

CREATE TRIGGER tr_update_flight_status

BEFORE UPDATE
ON `flights`
FOR EACH ROW
BEGIN
		IF
		old.`status` NOT IN ('Cancelled', 'Arrived')
		AND new.`status` = 'Arrived'
	THEN
		INSERT INTO `arrived_flights` (`flight_id`, `arrival_time`, `origin`, `destination`, `passengers`)
		VALUES (old.flight_id, new.arrival_time, 
				(SELECT a.airport_name FROM airports AS a WHERE a.airport_id = new.origin_airport_id),
				(SELECT a.airport_name FROM `airports` AS a WHERE a.airport_id = new.destination_airport_id),
				(SELECT COUNT(*) FROM tickets AS t
								 WHERE t.flight_id = old.flight_id));
	END IF;
	
END $$

DELIMITER ;