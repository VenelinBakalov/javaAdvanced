SELECT `deposit_group` FROM
(SELECT `deposit_group`, AVG(`magic_wand_size`) AS `avg_wand_size`
FROM `wizzard_deposits`
GROUP BY `deposit_group`) AS `avg_wand_size_by_group`
ORDER BY `avg_wand_size` ASC
LIMIT 1;

## Another idea

SELECT `deposit_group` FROM `wizzard_deposits`
GROUP BY `deposit_group`
HAVING AVG(`magic_wand_size`) = (
		SELECT AVG(`magic_wand_size`)
		FROM `wizzard_deposits`
		GROUP BY `deposit_group`
		ORDER BY AVG(`magic_wand_size`)
		LIMIT 1
);