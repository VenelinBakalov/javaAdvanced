DELIMITER $$

CREATE PROCEDURE `udp_submit_review`
	(`customer_id` INT, `review_content` VARCHAR(255),
	 `review_grade` INT, `airline_name` VARCHAR(30))
BEGIN
	DECLARE review_id INT;
	SET review_id := (SELECT COUNT(*) FROM `customer_reviews`) + 1;
	
	START TRANSACTION;
		INSERT INTO `customer_reviews` (`review_content`, `review_grade`, `airline_id`, `customer_id`)
		SELECT review_content, review_grade, a.airline_id, customer_id
		FROM airlines AS a
		WHERE a.airline_name = airline_name;
		
		IF airline_name NOT IN 
				(SELECT a.airline_name FROM `airlines` AS a)
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Airline does not exist';
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
END $$

DELIMITER ;