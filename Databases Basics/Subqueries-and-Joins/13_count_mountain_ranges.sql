SELECT c.country_code, COUNT(*) AS `mountain_range`
FROM `countries` AS c
LEFT OUTER JOIN `mountains_countries` AS mc
ON c.country_code = mc.country_code
LEFT OUTER JOIN `mountains` AS m
ON mc.mountain_id = m.id
WHERE c.country_name IN ('United States', 'Russia', 'Bulgaria')
GROUP BY c.country_code
ORDER BY mountain_range DESC;