DROP PROCEDURE IF EXISTS p_generate_t05_provider_data;

DELIMITER //

CREATE PROCEDURE p_generate_t05_provider_data(IN N INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    
    WHILE i <= N DO
        INSERT INTO T05_PROVIDER (
            C05_PROVIDER_ID, 
            C05_PROVIDER_NAME, 
            C05_PROVIDER_TAX_PCT
        ) VALUES (
            i, 
            CONCAT('Nhà cung cấp N', i), 
            10 + i
        );
        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;