DELIMITER $$

CREATE TRIGGER `delete_users`
BEFORE DELETE
ON `users`
FOR EACH ROW
BEGIN
	
	DELETE FROM `messages` WHERE `user_id` = old.`id`;
	DELETE FROM `messages_log` WHERE `user_id` = old.`id`;
	DELETE FROM `users_chats` WHERE `user_id` = old.`id`;
	
END $$

DELIMITER ;

DELETE FROM `users`
WHERE `id` = 1;