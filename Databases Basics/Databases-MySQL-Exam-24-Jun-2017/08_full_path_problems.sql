SELECT p.id,
		 CONCAT_WS(' - ', cat.name, c.name, p.name)
FROM `problems` AS p
	INNER JOIN `contests` AS c ON c.id = p.contest_id
	INNER JOIN `categories` AS cat ON cat.id = c.category_id
ORDER BY p.id ASC;