DELIMITER $$

CREATE PROCEDURE `udp_login` (`username` VARCHAR(30), `password` VARCHAR(30))
BEGIN
	START TRANSACTION;
	
		IF
			`username` NOT IN (SELECT u.username FROM `users` AS u)
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Username does not exists!';
			ROLLBACK;
		ELSEIF
			`password` != (SELECT u.password FROM users AS u WHERE u.username = `username`)
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Password is incorrect!';
			ROLLBACK;
		ELSEIF
			`username` IN (SELECT lin.username FROM `logged_in_users` AS lin)
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'User is already logged in!';
			ROLLBACK;
		ELSE
					INSERT INTO `logged_in_users` (`id`, `username`, `password`, `email`)
				SELECT u.id, u.username, u.password, u.email
				FROM `users` AS u
				WHERE u.username = username;
			COMMIT;
		END IF;
END $$

DELIMITER ;