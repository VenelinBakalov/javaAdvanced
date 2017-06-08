SELECT `town_id`, `name`
FROM `towns`
WHERE SUBSTRING(UPPER(`name`),1,1) IN ('M', 'K', 'B', 'E')
ORDER BY `name` ASC;