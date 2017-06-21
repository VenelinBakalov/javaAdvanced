SELECT u.nickname, c.email, c.`password`
FROM `users` AS u
INNER JOIN `credentials` AS c
ON u.credential_id = c.id
	AND RIGHT(c.email, 5) = 'co.uk'
ORDER BY c.email ASC;