DELIMITER $$

CREATE TRIGGER `insert_constraints`
BEFORE INSERT
ON `problems`
FOR EACH ROW
BEGIN
	IF 
		new.name NOT LIKE '% %'
	THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The given name is invalid!';
	ELSEIF
		new.points <= 0
	THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The problem\'s points cannot be less or equal to 0!';
	ELSEIF
		new.tests <= 0
	THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The problem\'s tests cannot be less or equal to 0!';
	END IF;
END $$

DELIMITER ;