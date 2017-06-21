SELECT c.id, c.title, m.id
FROM `chats` AS c
INNER JOIN `messages` AS m
ON c.id = m.chat_id
	AND m.sent_on < '2012-03-26'
	AND RIGHT(c.title, 1) = 'x'
ORDER BY c.id ASC, m.id ASC;