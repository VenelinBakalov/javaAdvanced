SELECT e.`first_name`, e.`last_name`
FROM `employees` AS e
WHERE UPPER(SUBSTRING(e.`first_name`,1,2))='SA';