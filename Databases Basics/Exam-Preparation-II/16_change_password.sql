DELIMITER $$

CREATE PROCEDURE `udp_change_password` (`email` VARCHAR(30), `password` VARCHAR(20))
BEGIN
	START TRANSACTION;
		UPDATE `credentials` AS c
		SET c.`password` = `password`
		WHERE c.email = `email`;
		
		IF
			`email` NOT IN (SELECT c.email FROM `credentials` AS c)
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The email doesn\'t exist!';
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
END $$

DELIMITER ;