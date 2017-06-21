DELETE l FROM `locations` AS l
LEFT OUTER JOIN `users` AS u
ON l.id = u.location_id
WHERE u.id IS NULL;

DELETE FROM `locations`
WHERE id NOT IN
		(SELECT u.location_id FROM `users` AS u);