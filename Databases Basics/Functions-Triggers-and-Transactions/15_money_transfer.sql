DELIMITER $$

CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
		UPDATE accounts AS a
		SET a.balance = a.balance - amount
		WHERE a.id = from_account_id;
		
		UPDATE accounts AS a
		SET a.balance = a.balance + amount
		WHERE a.id = to_account_id;
		
		IF from_account_id NOT IN (SELECT a.id FROM accounts AS a)
			OR to_account_id NOT IN (SELECT a.id FROM accounts AS a)
			OR from_account_id = to_account_id
		THEN
			ROLLBACK;
		ELSEIF amount < 0
		THEN
			ROLLBACK;
		ELSEIF 
			(SELECT a.balance FROM accounts AS a WHERE a.id = from_account_id) < amount
		THEN
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
END $$

DELIMITER ;
		
CALL usp_transfer_money(1, 2, 10);

SELECT * FROM accounts AS a WHERE a.id = 1 OR a.id = 2;