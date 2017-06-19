DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(19,4), interest_rate DECIMAL(19,4), years INT)
RETURNS DECIMAL(19,4)
BEGIN
	DECLARE future_value DECIMAL(19,4);
	SET future_value := initial_sum * (POW((1 + interest_rate), years));
	RETURN future_value;
END $$
DELIMITER ;

select ufn_calculate_future_value(1000, 0.1, 5);

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(19,4))
BEGIN
	DECLARE years INT default 5;
	SELECT a.id, ah.first_name, ah.last_name, 
		SUM(a.balance) as `current_balance`,
		ufn_calculate_future_value(SUM(a.balance), interest_rate, years) AS `balance_in_5_years`
	FROM `account_holders` AS ah
	INNER JOIN `accounts` AS a
	ON ah.id = a.account_holder_id
		AND a.id = account_id
	GROUP BY a.id, ah.first_name, ah.last_name;
END $$

DELIMITER ;
CALL usp_calculate_future_value_for_account(1, 0.1);