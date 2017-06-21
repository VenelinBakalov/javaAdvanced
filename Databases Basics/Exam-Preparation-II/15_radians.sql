DELIMITER $$

CREATE FUNCTION `udf_get_radians`(`degrees` FLOAT)
RETURNS FLOAT
BEGIN
	DECLARE `radians` FLOAT;
	SET `radians` := `degrees` * PI() / 180;
	RETURN `radians`;
END $$

DELIMITER ;

SELECT udf_get_radians(22.12) AS radians;