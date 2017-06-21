SELECT u.nickname, c.title, l.latitude, l.longitude
FROM `users` AS u
INNER JOIN `users_chats` AS uc
ON u.id = uc.user_id
INNER JOIN `chats` AS c
ON uc.chat_id = c.id
INNER JOIN `locations` AS l
ON u.location_id = l.id
	AND l.latitude BETWEEN 41.139999 AND 44.129999
	AND l.longitude BETWEEN 22.209999 AND 28.359999
ORDER BY c.title ASC;