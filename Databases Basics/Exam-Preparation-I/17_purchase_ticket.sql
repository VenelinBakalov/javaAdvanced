DELIMITER $$

CREATE PROCEDURE `udp_purchase_ticket`
	(`customer_id` INT, `flight_id` INT, `ticket_price` DECIMAL(8,2),
	 `class` VARCHAR(6), `seat` VARCHAR(5))
BEGIN
	START TRANSACTION;
		INSERT INTO `tickets` (`price`, `class`, `seat`, `customer_id`, `flight_id`)
		VALUES (ticket_price, class, seat, customer_id, flight_id);
		
		UPDATE `customer_bank_accounts`
		SET `balance` = `balance` - `ticket_price`
		WHERE `customer_id` = `customer_id`;
		
		IF
			`ticket_price` > (SELECT cba.balance FROM `customer_bank_accounts` AS cba WHERE cba.customer_id = `customer_id`)
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient bank account balance for ticket purchase';
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
END $$

DELIMITER ;