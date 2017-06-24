SELECT c.id, c.name, COUNT(*) AS `submissions`
FROM `contests` AS c
	INNER JOIN `problems` AS p ON p.contest_id = c.id
	INNER JOIN `submissions` AS s ON s.problem_id = p.id
WHERE s.user_id IN (
							SELECT uc.user_id FROM `users_contests` AS uc
							WHERE uc.contest_id = c.id)
GROUP BY c.id, c.name
ORDER BY `submissions` DESC, c.id ASC;