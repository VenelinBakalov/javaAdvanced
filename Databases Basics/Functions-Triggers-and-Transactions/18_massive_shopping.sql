DELIMITER $$

CREATE PROCEDURE `usp_buy_items_in_level_range` (`user_game_id` INT, `from_level` INT, `to_level` INT)
BEGIN
	DECLARE current_cash DECIMAL(19,4) DEFAULT 0;
	START TRANSACTION;
		INSERT INTO `user_game_items`(`item_id`, `user_game_id`)
		SELECT 
				i.id, user_game_id 
		FROM `items` AS i 
		WHERE i.min_level BETWEEN from_level AND to_level;
		
		UPDATE `users_games`
		SET `cash` = `cash` - (SELECT SUM(i.price) FROM `items` AS i WHERE i.min_level BETWEEN from_level AND to_level)
		WHERE id = user_game_id;
		
		SET current_cash = (SELECT ug.cash FROM `users_games` AS ug WHERE ug.id = user_game_id);
		
		IF
			current_cash < 0
		THEN
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
END $$

DELIMITER $$

CREATE PROCEDURE `usp_massive_shopping`()
BEGIN
	DECLARE `stamat_safflower_id` INT DEFAULT 0;
	SET stamat_safflower_id = (SELECT ug.id FROM `users_games` AS ug
										INNER JOIN `users` AS u ON u.id = ug.user_id
										INNER JOIN `games` AS g ON g.id = ug.game_id
										WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');
										
	CALL usp_buy_items_in_level_range(stamat_safflower_id, 11, 12);
	CALL usp_buy_items_in_level_range(stamat_safflower_id, 19, 21);
	
	SELECT i.name AS `Item Name` FROM `items` AS i
	INNER JOIN `user_game_items` AS ugi ON ugi.item_id = i.id
	INNER JOIN `users_games` AS ug ON ugi.user_game_id = ug.id
	INNER JOIN `games` AS g ON g.id = ug.game_id
	WHERE g.name = 'Safflower'
	ORDER BY i.name ASC;
	
	SELECT ug.cash FROM `users_games` AS ug WHERE ug.id = stamat_safflower_id;
	
END $$

DELIMITER ;

CALL usp_massive_shopping();