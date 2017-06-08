SELECT `town_id`, `name`
FROM `towns`
WHERE SUBSTRING(UPPER(`name`),1,1) NOT IN ('R', 'B', 'D')
ORDER BY `name` ASC;