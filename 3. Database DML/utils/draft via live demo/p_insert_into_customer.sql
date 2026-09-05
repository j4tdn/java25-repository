
DROP PROCEDURE IF EXISTS p_insert_into_customer;

DELIMITER $$

CREATE PROCEDURE p_insert_into_customer()
BEGIN
	DECLARE i INT DEFAULT 1;
    
    WHILE i <= 10 DO
        INSERT INTO T15_CUSTOMER(C15_CUSTOMER_ID,C15_CUSTOMER_NAME,C15_CUSTOMER_EMAIL,C15_CUSTOMER_ADDRESS,C15_CUSTOMER_PHONE,C15_CUSTOMER_PASSWORD,C15_GMAIL_TOKEN) 
        VALUES (
			i, 
            concat('Khách hàng ', i),
            concat('c', i, '@gmail.com'),
            concat('Địa chỉ ', i),
            '123456789',
            '$2a$12$xYfAVndgk8h77e0nwrMVW.MBUoQ83NUOZutGj68qerRYduUfFH1f6',
            concat('c', i, IF(i MOD 2 = 0, 'auto', 'def'))
        );
        SET i = i + 1;
    END WHILE;
END $$