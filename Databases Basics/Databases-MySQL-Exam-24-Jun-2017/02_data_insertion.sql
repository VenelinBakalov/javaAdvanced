INSERT INTO `submissions` (`passed_tests`, `problem_id`, `user_id`)
SELECT CEIL((SQRT(POW(CHAR_LENGTH(p.name), 3)) - CHAR_LENGTH(p.name))),
		 p.id,
		 CEIL((p.id * 3) / 2)
FROM `problems` AS p
WHERE p.id BETWEEN 1 AND 10;