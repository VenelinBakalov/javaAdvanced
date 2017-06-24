UPDATE `problems` AS p
	INNER JOIN `contests` AS c
	ON c.id = p.contest_id
	INNER JOIN `categories` AS cat
	ON cat.id = c.category_id
	INNER JOIN `submissions` AS s
	ON s.problem_id = p.id
SET p.tests = (
				CASE p.id % 3
					WHEN 0 THEN CHAR_LENGTH(cat.name)
					WHEN 1 THEN (SELECT SUM(s.id) FROM `submissions` AS s
										WHERE s.problem_id = p.id)
					WHEN 2 THEN CHAR_LENGTH(c.name)
					END)
WHERE p.tests = 0;