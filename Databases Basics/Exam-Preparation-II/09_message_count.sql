SELECT c.id, COUNT(m.id) AS `total_messages`
FROM `chats` AS c
INNER JOIN `messages` AS m
ON c.id = m.chat_id
	AND m.id < 90
GROUP BY c.id
ORDER BY `total_messages` DESC, c.id ASC
LIMIT 5;