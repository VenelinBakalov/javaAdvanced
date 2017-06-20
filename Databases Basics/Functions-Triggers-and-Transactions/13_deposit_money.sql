DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
		UPDATE `accounts` AS a
		SET a.balance = a.`balance` + `money_amount`
		WHERE a.id = `account_id`;
	
		IF `money_amount` < 0
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid amount';
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
END $$
DELIMITER ;

CALL usp_deposit_money(1, 10);

SELECT * FROM accounts AS a WHERE a.id = 1;