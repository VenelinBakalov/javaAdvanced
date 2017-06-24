SELECT * FROM
(SELECT c.id, c.name, COUNT(uc.user_id) AS `contestants`
FROM `contests` AS c
	LEFT OUTER JOIN `users_contests` AS uc ON uc.contest_id = c.id
GROUP BY c.id, c.name
ORDER BY contestants DESC, contestants ASC, c.id ASC
LIMIT 5) AS  top_five_contests
ORDER BY top_five_contests.contestants ASC, top_five_contests.id ASC;