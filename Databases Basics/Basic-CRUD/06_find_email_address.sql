SELECT 
	CONCAT(`first_name`, '.', `last_name`, '@softuni.bg')
FROM
	`employees` AS `full_email_address`;