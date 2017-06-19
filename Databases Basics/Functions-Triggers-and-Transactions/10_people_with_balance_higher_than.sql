DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(total_amount DECIMAL(19,4))
BEGIN
	SELECT total_balance.first_name, total_balance.last_name
	FROM
	(SELECT ah.first_name, ah.last_name, SUM(a.balance) as `sum`
	FROM `account_holders` AS ah
	INNER JOIN `accounts` AS a
	ON ah.id = a.account_holder_id
	GROUP BY ah.first_name, ah.last_name) as total_balance
	WHERE total_balance.`sum` > total_amount
	ORDER BY total_balance.first_name, total_balance.last_name;
END $$

DELIMITER ;
CALL usp_get_holders_with_balance_higher_than(7000);

CREATE PROCEDURE usp_get_holders_with_balance_higher_than(number DECIMAL(19,4))
  BEGIN
    SELECT ah.first_name, ah.last_name
      FROM `account_holders` AS ah
      INNER JOIN `accounts` AS a
        ON ah.id = a.account_holder_id
     GROUP BY ah.first_name, ah.last_name
     HAVING SUM(a.balance) > number;
  END;