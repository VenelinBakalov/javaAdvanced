SELECT u.id, u.nickname, u.age
FROM `users` AS u
WHERE u.location_id IS NULL
ORDER BY u.id ASC;