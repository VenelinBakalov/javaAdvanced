SELECT c.title, c.is_active
FROM `chats` AS c
WHERE (c.is_active = false
		AND CHAR_LENGTH(c.title) < 5) OR SUBSTRING(c.title, 3, 2) = 'tl'
ORDER BY c.title DESC;
