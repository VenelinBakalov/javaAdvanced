SELECT COUNT(*) AS `country_count`
FROM `countries` AS c
LEFT OUTER JOIN `mountains_countries` AS mc
ON c.country_code = mc.country_code
WHERE mc.country_code IS NULL;