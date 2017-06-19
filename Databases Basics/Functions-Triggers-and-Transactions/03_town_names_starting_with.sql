DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(name_starting_with VARCHAR(50))
BEGIN
	SELECT t.name
	FROM `towns` AS t
	WHERE LOCATE(name_starting_with, t.name) = 1
	ORDER BY t.name ASC;
END $$
DELIMITER ;
CALL usp_get_towns_starting_with('b');
