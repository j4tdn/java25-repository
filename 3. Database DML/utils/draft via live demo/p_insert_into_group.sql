DELIMITER $$

CREATE PROCEDURE p_insert_into_group(numberOfGroups INT)
BEGIN
    DECLARE running INT DEFAULT 1;
    
    WHILE running <= numberOfGroups DO
		INSERT INTO t02_item_group(
			C02_ITEM_GROUP_ID,
			C02_ITEM_GROUP_NAME, 
            C02_STATUS
		)
		VALUES (
			running, 
            concat('Loại Hàng ', running), 
            random_range(0,1)
		);
        SET running = running + 1;
    END WHILE;
END$$

DELIMITER ;