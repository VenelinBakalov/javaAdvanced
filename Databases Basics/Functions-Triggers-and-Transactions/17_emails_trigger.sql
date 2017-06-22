CREATE TABLE `notification_emails`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`recipient` INT,
	`subject` VARCHAR(200),
	`body` VARCHAR(200)
);

DELIMITER $$

CREATE TRIGGER `notification_email`
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO `notification_emails` (`recipient`, `subject`, `body`)
	VALUES (new.account_id, CONCAT('Balance change for account: ', new.account_id),
				CONCAT('On ', 
				DATE_FORMAT(NOW(), '%b %d %Y at %r), ' your balance was changed from ', new.old_sum, ' to ', new.new_sum, '.'));
END $$

DELIMITER ;