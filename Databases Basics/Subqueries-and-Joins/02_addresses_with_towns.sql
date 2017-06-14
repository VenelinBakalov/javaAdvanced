SELECT e.`first_name`, e.`last_name`, t.`name` AS 'town', a.`address_text`
FROM `employees` AS e
INNER JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
INNER JOIN `towns` AS t
ON a.`town_id` = t.`town_id`
ORDER BY e.`first_name` ASC, e.`last_name`
LIMIT 5;