SELECT c.id, c.name, SUM(p.points) AS maximum_points
FROM `contests` AS c
	INNER JOIN `problems` AS p ON p.contest_id = c.id
GROUP BY c.id, c.name
ORDER BY maximum_points DESC, c.id ASC;