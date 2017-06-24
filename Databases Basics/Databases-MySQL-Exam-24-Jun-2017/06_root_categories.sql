SELECT c.id, c.name
FROM `categories` AS c
WHERE c.parent_id IS NULL
ORDER BY c.id ASC;