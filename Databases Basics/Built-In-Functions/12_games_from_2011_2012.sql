SELECT `name`, DATE_FORMAT(`start`, '%Y-%m-%d')
FROM `games`
WHERE EXTRACT(year FROM `start`) IN (2011, 2012)
ORDER BY `start` ASC, `name` ASC
LIMIT 50;