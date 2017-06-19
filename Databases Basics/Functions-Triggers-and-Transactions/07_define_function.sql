DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(30), word VARCHAR(200))
RETURNS BOOL
BEGIN
	DECLARE lenght INT DEFAULT char_length(word);
	DECLARE idx INT DEFAULT 1;
	WHILE idx <= lenght
	DO
		IF LOCATE(SUBSTRING(word, idx, 1), set_of_letters) < 1
		THEN
			RETURN FALSE;
		END IF;
		SET idx := idx + 1;
	END WHILE;
	RETURN TRUE;
END $$
DELIMITER ;

SELECT ufn_is_word_comprised('bobr', 'Rob');