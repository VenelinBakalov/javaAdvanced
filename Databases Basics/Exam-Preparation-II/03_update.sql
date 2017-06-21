UPDATE `chats` AS c
	INNER JOIN `messages` AS m
	ON c.id = m.chat_id
		AND	m.sent_on < c.start_date
SET c.start_date = 
	(SELECT MIN(m.sent_on) FROM `messages` AS m WHERE m.chat_id = c.id);
