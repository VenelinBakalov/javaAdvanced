SELECT c.country_name, r.river_name
FROM `countries` AS c
LEFT OUTER JOIN `countries_rivers` AS cr
ON c.country_code = cr.country_code
LEFT OUTER JOIN `rivers` AS r
ON cr.river_id = r.id
WHERE c.continent_code IN
			(SELECT ct.continent_code FROM `continents` AS ct
			WHERE ct.continent_name = 'Africa')
ORDER BY c.country_name ASC
LIMIT 5;