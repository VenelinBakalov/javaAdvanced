DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
	SELECT e.first_name, e.last_name
	FROM `employees` AS e
	INNER JOIN `addresses` AS a
	ON e.address_id = a.address_id
	INNER JOIN `towns` AS t
	ON a.town_id = t.town_id
		AND t.name = town_name
	ORDER BY e.first_name, e.last_name;
END $$

DELIMITER ;
CALL usp_get_employees_from_town('Sofia');