CREATE TABLE `messages_log`
(
	`id` INT,
	`content` VARCHAR(200),
	`sent_on` DATE,
	`chat_id` INT,
	`user_id` INT,
	CONSTRAINT `pk_messages_log` PRIMARY KEY (`id`),
	CONSTRAINT `fk_messages_log_chats` FOREIGN KEY (`chat_id`) REFERENCES `chats` (`id`),
	CONSTRAINT `fk_messages_log` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

DELIMITER $$

CREATE TRIGGER `archive_messages`
AFTER DELETE
ON `messages`
FOR EACH ROW
BEGIN
	INSERT INTO `messages_log`
	VALUES (old.id, old.content, old.sent_on, old.chat_id, old.user_id);
END $$

DELIMITER ;

DELETE FROM messages
WHERE id = 1;