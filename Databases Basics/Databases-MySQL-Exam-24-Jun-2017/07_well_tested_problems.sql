SELECT p.id, p.name, p.tests
FROM `problems` AS p
WHERE p.tests > p.points
	AND p.name LIKE '% %'
ORDER BY p.id DESC;