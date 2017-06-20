DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
	UPDATE `accounts` AS a
	SET a.balance = a.balance - money_amount
	WHERE a.id = account_id;
	
	IF account_id NOT IN (SELECT a.id FROM accounts AS a)
	THEN
		ROLLBACK;
	ELSEIF 
		(SELECT a.balance FROM accounts AS a WHERE a.id = account_id) < money_amount
	THEN
		ROLLBACK;
	ELSEIF money_amount < 0 
	THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	
END $$

DELIMITER ;
		
CALL usp_withdraw_money(1, 10);

SELECT * FROM accounts AS a WHERE a.id = 1;