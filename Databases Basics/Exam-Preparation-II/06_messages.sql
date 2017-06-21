SELECT m.content, m.sent_on
FROM `messages` AS m
WHERE m.sent_on > DATE('2014.05.12')
		AND LOCATE('just', m.content) > 0
ORDER BY m.id DESC;
