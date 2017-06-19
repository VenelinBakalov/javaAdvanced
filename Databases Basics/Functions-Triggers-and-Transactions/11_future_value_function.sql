DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(19,2), interest_rate DECIMAL(19,4), years INT)
RETURNS DECIMAL(19,2)
BEGIN
	DECLARE future_value DECIMAL(19,2);
	SET future_value := initial_sum * (POW((1 + interest_rate), years));
	RETURN future_value;
END $$
DELIMITER ;

select ufn_calculate_future_value(1000, 0.1, 5);