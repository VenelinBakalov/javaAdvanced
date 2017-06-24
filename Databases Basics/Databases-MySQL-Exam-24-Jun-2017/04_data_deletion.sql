SET foreign_key_checks = 0;
DELETE FROM `users`
WHERE `id` NOT IN (SELECT uc.user_id FROM `users_contests` AS uc);
SET foreign_key_checks = 1;

DELETE u FROM `users` AS u
INNER JOIN `users_contests` AS uc
WHERE u.id NOT IN (SELECT uc.user_id FROM `users_contests` AS uc);