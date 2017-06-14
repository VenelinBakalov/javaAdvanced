SELECT e.`employee_id`, e.`job_title`, e.`address_id`, a.`address_text`
FROM `employees` AS e
INNER JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
ORDER BY e.`address_id` ASC
LIMIT 5;