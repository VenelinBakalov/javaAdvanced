DELIMITER $$

CREATE PROCEDURE `udp_evaluate` (`id` INT)
BEGIN
	START TRANSACTION;
	
		INSERT INTO `evaluated_submissions` (`id`,`problem`, `user`, `result`)
		SELECT id, p.name, u.username,
					CEIL(((CAST(p.points AS DECIMAL(19,4)) / p.tests) * s.passed_tests)) AS `result`
		FROM `submissions` AS s
			INNER JOIN `problems` AS p ON p.id = s.problem_id
			INNER JOIN `users` AS u ON u.id = s.user_id
		WHERE s.id = id;
		
		IF
			id NOT IN (SELECT s.id FROM `submissions` AS s)
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Submission does not exist!';
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
END $$

DELIMITER ;

CALL `udp_evaluate`(1);