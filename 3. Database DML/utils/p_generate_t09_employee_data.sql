DROP PROCEDURE IF EXISTS p_generate_t09_employee_data;

DELIMITER $$

CREATE PROCEDURE p_generate_t09_employee_data()
BEGIN
	DECLARE i INT DEFAULT 1;
    
    WHILE i <= 10 DO
        INSERT INTO T09_EMPLOYEE(C09_EMPLOYEE_ID, C09_EMPLOYEE_NAME, C09_EMPLOYEE_EMAIL, C09_EMPLOYEE_PHONE) 
        VALUES (
			i, 
            concat('Nhân viên ', i),
            concat('nv', i, '@gmail.com'),
            concat(i, '23456789')
        );
        SET i = i + 1;
    END WHILE;
END $$