SELECT u.id, u.username, u.password
FROM `users` AS u
WHERE u.password IN (
							SELECT us.password FROM `users` AS us
							WHERE us.username != u.username)
ORDER BY u.username ASC, u.id ASC;