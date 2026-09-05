
-- T02_ITEM_GROUP
INSERT INTO T02_ITEM_GROUP
(
    C02_ITEM_GROUP_ID,
    C02_ITEM_GROUP_NAME,
    C02_STATUS
)
VALUES
    (1, 'Áo', 1),
    (2, 'Quần', 1),
    (3, 'Giày', 1),
    (4, 'Dép', 1),
    (5, 'Mũ', 1),
    (6, 'Thắt lưng', 1),
    (7, 'Túi xách', 1);
    
-- T03_SUB_ITEM_GROUP
-- Cách 1: Manual
-- Cách 2: Dynamic
INSERT INTO T03_SUB_ITEM_GROUP
    (
        C03_SIG_ID,
        C03_SIG_NAME,
        C03_ITEM_GROUP_ID
    )
SELECT 
		(t02.C02_ITEM_GROUP_ID * 10) + SEQ.NUM AS SIG_ID,
        CONCAT(t02.C02_ITEM_GROUP_NAME, ' ', (t02.C02_ITEM_GROUP_ID * 10) + SEQ.NUM) AS SIG_NAME,
        t02.C02_ITEM_GROUP_ID AS ITEM_GROUP_ID
    FROM T02_ITEM_GROUP t02
    CROSS JOIN
    (
        SELECT 1 AS NUM
        UNION ALL
        SELECT 2
        UNION ALL
        SELECT 3
    ) SEQ
    WHERE SEQ.NUM <=
        CASE
            WHEN MOD(t02.C02_ITEM_GROUP_ID, 2) = 0 THEN 2
            ELSE 3
        END;
        
-- T01_ITEM
-- Tạo dữ liệu mẫu cho bảng T01_ITEM
INSERT INTO T01_ITEM (
    C01_ITEM_ID, 
    C01_ITEM_NAME, 
    C01_BUY_PRICE, 
    C01_MATERIAL, 
    C01_COLOR, 
    C01_SIG_ID, 
    C01_ITEM_GROUP_ID
) VALUES 
(1, 'Áo 1', 100, 'M1', 'RED', 11, 1),
(2, 'Áo 2', 110, 'M1', 'GREEN', 11, 1),
(3, 'Áo 3', 120, 'M1', 'BLUE', 12, 1),
(4, 'Quần 4', 130, 'M2', 'BLACK', 21, 2),
(5, 'Quần 5', 140, 'M2', 'WHITE', 21, 2),
(6, 'Giày 6', 150, 'M2', 'WHITE', 31, 3),
(7, 'Giày 7', 160, 'M3', 'ORIGIN', 32, 3),
(8, 'Giày 8', 170, 'M3', 'GRAY', 32, NULL),
(9, 'Giày 9', 180, 'M3', 'RED', 33, NULL),
(10, 'Giày 10', 190, 'M4', 'GREEN', 31, 3),
(11, 'Giép 11', 200, 'M4', 'BLUE', 41, 4),
(12, 'Áo 12', 210, 'M4', 'BLACK', 12, 1),
(13, 'Giép 13', 220, 'M5', 'WHITE', 42, 4),
(14, 'Mũ 14', 230, 'M5', 'WHITE', NULL, 5),
(15, 'Mũ 15', 240, 'M5', 'ORIGIN', NULL, 5),
(16, 'Thắt lưng 16', 250, 'M2', 'GRAY', 61, 6),
(17, 'Thắt lưng 17', 260, 'M2', 'BLUE', NULL, 6),
(18, 'Mũ 18', 270, 'M4', 'BLACK', 52, 5),
(19, 'Túi xách 1', 280, 'M4', 'WHITE', NULL, 7),
(20, 'Túi xách 2', 290, 'M3', 'WHITE', 72, 7);

-- T04_SIZE
INSERT INTO T04_SIZE (
    C04_SIZE_ID, 
    C04_SIZE_NAME, 
    C04_GENDER, 
    C04_SIZE_DESC
) VALUES 
(1, 'S', 0, 'Size ''S'' cho Nữ'),
(2, 'M', 0, 'Size ''M'' cho Nữ'),
(3, 'L', 0, 'Size ''L'' cho Nữ'),
(4, 'XL', 0, 'Size ''XL'' cho Nữ'),
(5, 'XXL', 0, 'Size ''XXL'' cho Nữ'),
(6, 'S', 1, 'Size ''S'' cho Nam'),
(7, 'M', 1, 'Size ''M'' cho Nam'),
(8, 'L', 1, 'Size ''L'' cho Nam'),
(9, 'XL', 1, 'Size ''XL'' cho Nam'),
(10, 'XXL', 1, 'Size ''XXL'' cho Nam');

-- T05_PROVIDER
CALL p_generate_t05_provider_data(5);

-- T90_PAYMENT_METHOD
INSERT INTO T90_PAYMENT_METHOD (C90_PAYMENT_METHOD_ID, C90_PAYMENT_METHOD_NAME) VALUES
(1, 'Tiền mặt'),
(2, 'Thẻ tín dụng'),
(3, 'Thẻ ghi nợ'),
(4, 'Ví điện tử');

-- T91_ORDER_STATUS
INSERT INTO T91_ORDER_STATUS (C91_ORDER_STATUS_ID, C91_ORDER_STATUS_DESC) VALUES
(1, 'Chờ xác nhận'),
(2, 'Đang đóng gói'),
(3, 'Đóng gói hoàn thành'),
(4, 'Đang vận chuyển'),
(5, 'Giao hàng thành công'),
(6, 'Giao hàng thất bại'),
(7, 'Hủy đơn hàng');

-- T08_CUSTOMER
CALL p_generate_t08_customer_data();

-- T09_EMPLOYEE
CALL p_generate_t09_employee_data();

-- T06_ORDER
INSERT INTO T06_ORDER (
    C06_ORDER_ID, 
    C06_DELIVERY_ADDRESS, 
    C06_RECEIVER_PHONE, 
    C06_ORDER_DATE, 
    C06_EXPECTED_DELIVERY_DATE, 
    C06_PAYMENT_METHOD_ID, 
    C06_CUSTOMER_ID, 
    C06_EMPLOYEE_ID
) VALUES 
(1, 'Địa chỉ 1', '123459789', STR_TO_DATE('10.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('10.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 1, 1, 8),
(2, 'Địa chỉ 2', '123459789', STR_TO_DATE('12.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('12.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 1, 2, 8),
(3, 'Địa chỉ 3', '123459789', STR_TO_DATE('14.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('14.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 2, 3, 9),
(4, 'Địa chỉ 4', '123459789', STR_TO_DATE('16.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('16.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 3, 4, 10),
(5, 'Địa chỉ 5', '123459789', STR_TO_DATE('18.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('18.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 4, 5, 8),
(6, 'Địa chỉ 6', '123459789', STR_TO_DATE('12.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('12.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 3, 6, 9),
(7, 'Địa chỉ 7', '123459789', STR_TO_DATE('14.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('14.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 2, 7, 10),
(8, 'Địa chỉ 8', '123459789', STR_TO_DATE('18.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('18.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 1, 8, 8),
(9, 'Địa chỉ 9', '123459789', STR_TO_DATE('18.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('18.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 4, 9, 6),
(10, 'Địa chỉ 10', '123459789', STR_TO_DATE('18.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('18.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 4, 10, 8),
(11, 'Địa chỉ 11', '123459789', STR_TO_DATE('20.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('20.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 3, 2, 9),
(12, 'Địa chỉ 12', '123459789', STR_TO_DATE('26.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('26.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 2, 4, 10),
(13, 'Địa chỉ 13', '123459789', STR_TO_DATE('28.04.2026 08:10:20', '%d.%m.%Y %H:%i:%s'), DATE_ADD(STR_TO_DATE('28.04.2026', '%d.%m.%Y'), INTERVAL 5 DAY), 1, 6, 8);

-- T10_GALLARY
INSERT INTO T10_GALLERY(C10_ITEM_ID, C10_IMAGE_PATH)
SELECT C01_ITEM_ID,
	   concat('file:///images/shopping/s_', C01_ITEM_ID, '.png')
  FROM T01_ITEM; 
 
-- T15_ITEM_RECEIPT_DETAIL
INSERT INTO T15_ITEM_RECEIPT_DETAIL(C15_PROVIDER_ID,C15_ITEM_ID,C15_AMOUNT,C15_BUY_PRICE,C15_RECEIPT_DATE)
WITH CTE_PROVIDER_DETAIL AS (
SELECT t5.C05_PROVIDER_ID providerId,
       t1.C01_ITEM_ID itemId,
       777 amount,
       f_random(50, 200) buyPrice,
       DATE_SUB(current_date(), INTERVAL f_random(1,5) DAY) receiptDate
  FROM T05_PROVIDER t5, T01_ITEM t1
 WHERE t5.C05_PROVIDER_ID MOD 2 != 0
   AND t1.C01_ITEM_ID MOD 2 != 0
UNION ALL
SELECT t5.C05_PROVIDER_ID providerId,
       t1.C01_ITEM_ID itemId,
       820 amount,
       f_random(100, 200) buyPrice,
       DATE_SUB(current_date(), INTERVAL f_random(1,5) DAY) receiptDate
  FROM T05_PROVIDER t5, T01_ITEM t1
 WHERE t5.C05_PROVIDER_ID MOD 2 = 0
   AND t1.C01_ITEM_ID MOD 2 = 0
)
SELECT * FROM CTE_PROVIDER_DETAIL; 
 
-- T14_ITEM_DETAIL
INSERT INTO T14_ITEM_DETAIL(C14_ITEM_ID,C14_SIZE_ID,C14_SALES_PRICE,C14_AMOUNT)
WITH CTE_ITEM_BUY_PRICE AS (
	SELECT C15_ITEM_ID itemId,
           MAX(C15_BUY_PRICE) buyPrice 
	  FROM T15_ITEM_RECEIPT_DETAIL
	 GROUP BY C15_ITEM_ID
), CTE_ITEM_DETAILS AS (
	SELECT t1.C01_ITEM_ID itemId,
		   t4.C04_SIZE_ID sizeId,
		   cte_bprice.buyPrice*2 + t4.C04_SIZE_ID*5 salesPrice,
		   125 amount
	  FROM T01_ITEM t1, T04_SIZE t4, CTE_ITEM_BUY_PRICE cte_bprice
	  WHERE t1.C01_ITEM_ID MOD 2 != 0
	   AND t4.C04_SIZE_ID MOD 2 != 0
	   AND t1.C01_ITEM_ID = cte_bprice.itemId
	UNION ALL
	SELECT t1.C01_ITEM_ID itemId, -- item, size chẵn
		   t4.C04_SIZE_ID sizeId,
		   cte_bprice.buyPrice*2 + t4.C04_SIZE_ID*5 + 20 salesPrice,
		   280 amount
	  FROM T01_ITEM t1, T04_SIZE t4, CTE_ITEM_BUY_PRICE cte_bprice
	  WHERE t1.C01_ITEM_ID MOD 2 = 0
	   AND t4.C04_SIZE_ID MOD 2 = 0
	   AND t1.C01_ITEM_ID = cte_bprice.itemId
)
SELECT * FROM CTE_ITEM_DETAILS; 

-- T16_ORDER_DETAIL
INSERT INTO T16_ORDER_DETAIL (C16_ORDER_ID, C16_ITEM_DETAIL_ID, C16_AMOUNT) VALUES
(1, 1, 2),(1, 3, 4),(2, 4, 2),(2, 5, 2),(3, 6, 4),
(3, 2, 4),(4, 8, 2),(4, 12, 4),(5, 88, 1),(5, 22, 3),(5, 11, 1),
(5, 33, 1), (6, 2, 1),(7, 1, 2),(8, 27, 1),(8, 23, 1),(8, 98, 2),
(9, 100, 6),(9, 11, 7),(9, 45, 2),(9, 22, 2),(9, 32, 1),(10, 18, 2),
(10, 29, 4),(11, 33, 2),(11, 65, 1),(11, 1, 1),(11, 2, 2),(11, 5, 5),
(11, 7, 10),(12, 55, 1),(13, 92, 1),(13, 14, 2);

SET FOREIGN_KEY_CHECKS = 1;