SELECT c.title, m.content
FROM `chats` AS c
LEFT OUTER JOIN `messages` AS m
ON c.id = m.chat_id
WHERE c.start_date = (SELECT MAX(c.start_date) FROM `chats` AS c)
ORDER BY m.sent_on ASC, m.id ASC;

SELECT c.title, m.content
FROM `chats` AS c
LEFT OUTER JOIN `messages` AS m
ON c.id = m.chat_id
WHERE c.id = (SELECT c.id FROM `chats` AS c ORDER BY c.start_date DESC LIMIT 1)
ORDER BY m.sent_on ASC, m.id ASC;
