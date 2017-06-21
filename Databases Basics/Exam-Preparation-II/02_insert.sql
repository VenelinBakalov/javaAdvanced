INSERT INTO `messages`(`content`, `sent_on`, `chat_id`, `user_id`)
SELECT CONCAT_WS('-', u.age, u.gender, l.latitude, l.longitude), '2016-12-15',
		 CASE
		 	WHEN u.gender = 'F' THEN CEILING(SQRT(u.age * 2))
		 	WHEN u.gender = 'M' THEN POW(u.age / 18, 3)
		 END,
		 u.id
FROM `users` AS u
INNER JOIN `locations` AS l
ON u.location_id = l.id
	AND u.id BETWEEN 10 AND 20;