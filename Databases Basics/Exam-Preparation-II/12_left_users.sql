SELECT m.id, c.id, u.id
FROM `messages` AS m
INNER JOIN `chats` AS c
ON m.chat_id = c.id
INNER JOIN `users` AS u
ON u.id = m.user_id
 AND c.id = 17
WHERE u.id NOT IN (SELECT uc.user_id FROM users_chats AS uc WHERE uc.chat_id = 17)
ORDER BY m.id DESC;