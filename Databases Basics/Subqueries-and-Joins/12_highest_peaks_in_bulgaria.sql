SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM `countries` AS c
INNER JOIN `mountains_countries` AS mc
ON c.country_code = mc.country_code
INNER JOIN `mountains` AS m
ON mc.mountain_id = m.id
INNER JOIN `peaks` AS p
ON m.id = p.mountain_id
	AND c.country_name = 'Bulgaria'
	AND p.elevation > 2835
ORDER BY p.elevation DESC;