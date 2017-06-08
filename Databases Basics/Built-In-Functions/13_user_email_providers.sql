SELECT `user_name`, SUBSTRING(`email`, LOCATE('@', `email`) + 1) AS `Email Provider`
FROM `users`
ORDER BY `Email Provider` ASC, `user_name` ASC;