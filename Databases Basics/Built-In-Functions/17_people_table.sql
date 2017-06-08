CREATE TABLE `people`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50) NOT NULL,
	`birthdate` DATETIME
);

SELECT `name`,
	TIMESTAMPDIFF(YEAR, `birthdate`, NOW()) AS `age_in_years`,
	TIMESTAMPDIFF(MONTH, `birthdate`, NOW()) AS 'age_in_months',
	TIMESTAMPDIFF(DAY, `birthdate`, NOW()) AS 'age_in_days',
	TIMESTAMPDIFF(MINUTE, `birthdate`, NOW()) AS 'age_in_minutes'
FROM `people`;