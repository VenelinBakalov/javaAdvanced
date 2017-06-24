SELECT c.id, c.name
FROM `categories` AS c
	LEFT OUTER JOIN `categories` AS children_cat
	ON children_cat.parent_id = c.id
WHERE children_cat.id IS NULL
ORDER BY c.name ASC, c.id ASC;

SELECT c.id, c.name
FROM categories AS c
WHERE c.id NOT IN
		(SELECT cat.parent_id FROM categories AS cat WHERE cat.parent_id IS NOT NULL)
ORDER BY c.name ASC, c.id ASC;