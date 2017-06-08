SELECT p.`peak_name`, r.`river_name`, 
	CONCAT(LOWER(p.`peak_name`), SUBSTRING(LOWER(r.`river_name`), 2)) AS `mix`
FROM `peaks` AS p, `rivers` AS r
WHERE RIGHT(p.`peak_name`, 1) = LEFT(r.`river_name`, 1)
ORDER BY `mix` ASC;