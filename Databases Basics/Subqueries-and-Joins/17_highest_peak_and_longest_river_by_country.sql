SELECT c.`country_name`, 
		MAX(p.`elevation`) AS `highest_peak_elevation`,
		MAX(r.`length`) AS `longest_river_length`
FROM `countries` AS c
LEFT OUTER JOIN `mountains_countries` AS mc
ON c.country_code = mc.country_code
LEFT OUTER JOIN `mountains` AS m
ON mc.mountain_id = m.id
LEFT OUTER JOIN `peaks` AS p
ON p.mountain_id = m.id
LEFT OUTER JOIN `countries_rivers` AS cr
ON c.country_code = cr.country_code
LEFT OUTER JOIN `rivers` AS r
ON r.id = cr.river_id
GROUP BY c.country_name
ORDER BY `highest_peak_elevation` DESC, `longest_river_length` DESC,
c.country_name ASC
LIMIT 5;