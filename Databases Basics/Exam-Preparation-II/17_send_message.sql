DELIMITER $$

CREATE PROCEDURE `udp_send_message`(`user_id` INT, `chat_id` INT, `content` VARCHAR(200))
BEGIN
	START TRANSACTION;
		INSERT INTO `messages`(`content`, `sent_on`, `chat_id`, `user_id`)
		VALUES (content, '2016-12-15', chat_id, user_id);
		
		IF
			`user_id` NOT IN (SELECT uc.`user_id` FROM `users_chats` AS uc)
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'There is no chat with that user!';
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
END $$

DELIMITER ;