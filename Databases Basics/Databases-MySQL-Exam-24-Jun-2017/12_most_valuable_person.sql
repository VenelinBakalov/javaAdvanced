SELECT s.id, u.username, p.name, CONCAT(s.passed_tests, ' / ', p.tests) AS `result`
FROM `submissions` AS s
	INNER JOIN `users` AS u ON u.id = s.user_id
	INNER JOIN `problems` AS p ON p.id = s.problem_id
WHERE u.id = (
					SELECT u.id
					FROM `users` AS u
						INNER JOIN `users_contests` AS uc ON uc.user_id = u.id
					GROUP BY u.id
					ORDER BY COUNT(*) DESC
					LIMIT 1)
ORDER BY s.id DESC;