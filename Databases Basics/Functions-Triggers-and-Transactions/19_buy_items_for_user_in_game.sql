DELIMITER $$

CREATE PROCEDURE `usp_buy_item` (IN `user_id` INT, IN `item_name` VARCHAR(50))
BEGIN
	DECLARE current_cash DECIMAL(19,4) DEFAULT 0;
	DECLARE item_level INT DEFAULT 0;
	
	START TRANSACTION;
		INSERT INTO `user_game_items`(`item_id`, `user_game_id`)
		VALUES
			((SELECT i.id FROM `items` AS i WHERE i.name = item_name), user_id);
			
		UPDATE `users_games`
		SET `cash` = `cash` - (SELECT i.price FROM `items` AS i WHERE i.name = item_name)
		WHERE `id` = user_id;
		
		SET current_cash = (SELECT ug.cash FROM `users_games` AS ug
								  INNER JOIN `users` AS u ON u.id = ug.user_id
								  INNER JOIN `games` AS g ON g.id = ug.game_id
								  WHERE u.user_name = 'Alex' AND g.name = 'Edinburgh');
								  
		SET item_level = (SELECT i.min_level FROM `items` AS i WHERE i.name = item_name);
								  
		IF current_cash < 0
			OR item_level > (SELECT ug.`level` FROM `users_games` AS ug
							     INNER JOIN `users` AS u ON u.id = ug.user_id
								  INNER JOIN `games` AS g ON g.id = ug.game_id
								  WHERE u.user_name = 'Alex' AND g.name = 'Edinburgh')
		THEN
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
END $$


CREATE PROCEDURE `usp_buy_items_for_alex`()
BEGIN
	DECLARE alex_edinburgh_id INT DEFAULT 0;
	SET alex_edinburgh_id = (SELECT ug.id FROM `users_games` AS ug
									 INNER JOIN `users` AS u ON u.id = ug.user_id
									 INNER JOIN `games` AS g ON g.id = ug.game_id
									 WHERE u.user_name = 'Alex' AND g.name = 'Edinburgh');
	
	CALL usp_buy_item(alex_edinburgh_id, 'Blackguard');
	CALL usp_buy_item(alex_edinburgh_id, 'Bottomless Potion of Amplification');
	CALL usp_buy_item(alex_edinburgh_id, 'Eye of Etlich (Diablo III)');
	CALL usp_buy_item(alex_edinburgh_id, 'Gem of Efficacious Toxin');
	CALL usp_buy_item(alex_edinburgh_id, 'Golden Gorget of Leoric');
	CALL usp_buy_item(alex_edinburgh_id, 'Ziggurat Tooth');
	CALL usp_buy_item(alex_edinburgh_id, 'The Three Hundredth Spear');
	CALL usp_buy_item(alex_edinburgh_id, 'The Short Mans Finger');
	CALL usp_buy_item(alex_edinburgh_id, 'Tzo Krins Gaze');
	CALL usp_buy_item(alex_edinburgh_id, 'Valtheks Rebuke');
	CALL usp_buy_item(alex_edinburgh_id, 'Utars Roar');
	CALL usp_buy_item(alex_edinburgh_id, 'Urn of Quickening');
	CALL usp_buy_item(alex_edinburgh_id, 'Boots');
	CALL usp_buy_item(alex_edinburgh_id, 'Bombardiers Rucksack');
	CALL usp_buy_item(alex_edinburgh_id, 'Cloak of Deception');
	CALL usp_buy_item(alex_edinburgh_id, 'Hellfire Amulet');
	
	SELECT u.user_name, g.name, ug.cash, i.name
	FROM `users` AS u
	INNER JOIN `users_games` AS ug ON ug.user_id = u.id
	INNER JOIN `games` AS g ON g.id = ug.game_id
	INNER JOIN `user_game_items` AS ugi ON ugi.user_game_id = ug.id
	INNER JOIN `items` AS i ON i.id = ugi.item_id
	WHERE g.name = 'Edinburgh'
	ORDER BY i.name ASC;
	
END $$

DELIMITER ;