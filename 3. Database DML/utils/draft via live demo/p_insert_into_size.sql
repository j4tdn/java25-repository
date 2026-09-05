
DROP PROCEDURE IF EXISTS p_insert_into_size;

DELIMITER $$

CREATE PROCEDURE p_insert_into_size()
BEGIN
	DECLARE i INT DEFAULT 1;
    DECLARE is_female BIT(1);
    DECLARE size_name VARCHAR(50);
    
    WHILE i <= 10 DO
        SET is_female = i <= 5;
        SET size_name = ELT(IF(is_female, i, i - 5), 'S', 'M', 'L', 'XL', 'XXL');
		
        INSERT INTO T02_SIZE(C02_SIZE_ID, C02_SIZE_NAME, C02_GENDER, C02_SIZE_DESC) VALUES
        (i, size_name, NOT is_female, concat("Size '", size_name, "' cho ", IF(is_female, 'Nữ', 'Nam')));
        
        SET i = i + 1;
    END WHILE;
END $$