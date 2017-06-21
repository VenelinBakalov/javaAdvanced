SELECT u.nickname, u.gender, u.age
FROM `users` AS u
WHERE u.age BETWEEN 22 AND 37
ORDER BY u.id ASC;