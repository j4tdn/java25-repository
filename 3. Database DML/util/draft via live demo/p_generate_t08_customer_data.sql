DROP PROCEDURE IF EXISTS p_generate_t08_customer_data;

DELIMITER $$

CREATE PROCEDURE p_generate_t08_customer_data()
BEGIN
	DECLARE i INT DEFAULT 1;
    
    WHILE i <= 10 DO
        INSERT INTO T08_CUSTOMER(C08_CUSTOMER_ID,C08_CUSTOMER_NAME,C08_CUSTOMER_EMAIL,C08_CUSTOMER_PHONE,C08_CUSTOMER_ADDRESS,C08_CUSTOMER_PASSWORD,C08_SOCIAL_MEDIA,C08_SM_TOKEN) 
        VALUES (
			i, 
            concat('Khách hàng ', i),
            concat('c', i, '@gmail.com'),
            concat(i, '23456789'),
            concat('Địa chỉ ', i),
            '$2a$12$xYfAVndgk8h77e0nwrMVW.MBUoQ83NUOZutGj68qerRYduUfFH1f6',
            concat('sm', i, IF(i <= 5, '1', '2')),
            concat('c', i, IF(i MOD 2 = 0, 'auto', 'def'))
        );
        SET i = i + 1;
    END WHILE;
END $$