-- ======================= REFRESH DATA =======================

-- 1. Tạo dữ liệu kiểm thử cho bảng T07_BILL
SET @cancel_order_status_id = 7;

INSERT INTO t07_bill(C07_ORDER_ID,C07_TOTAL_OF_MONEY,C07_DELIVERY_FEE)
-- B1. Tìm các đơn hàng bị hủy
WITH cancel_orders AS (
	SELECT C17_ORDER_ID ORDER_ID 
      FROM t17_order_status_detail 
	 WHERE C17_ORDER_STATUS_ID = @cancel_order_status_id
)
-- B2. Lấy các đơn hàng không bị hủy và thông tin khác
SELECT C06_ORDER_ID BILL_ID,
       0 TOTAL_OF_MONEY,
       ELT(f_random(1, 4), 20, 30, 40, 50) DELIVERY_FEE
  FROM t06_order t06
 -- WHERE t06.C06_ORDER_ID NOT IN (SELECT ORDER_ID FROM cancel_orders); -- chạy tuần tự
 WHERE NOT EXISTS (SELECT 1
                     FROM cancel_orders co
					WHERE t06.C06_ORDER_ID = co.ORDER_ID); -- chạy song song

-- 2. Tạo dữ liệu kiểm thử cho bảng T17_ORDER_STATUS_DETAIL
INSERT INTO t17_order_status_detail(C17_ORDER_ID,C17_ORDER_STATUS_ID,C17_EMPLOYEE_ID,C17_LAST_UPDATED)
WITH CTE_ORDER_STATUS_DETAIL AS (
	SELECT C06_ORDER_ID ORDER_ID,
		   t91.C91_ORDER_STATUS_ID ORDER_STATUS_ID,
		   1 EMPLOYEE_ID,
		   DATE_SUB(current_timestamp(), INTERVAL (5 - t91.C91_ORDER_STATUS_ID) DAY) LAST_UPDATED
	  FROM t06_order t06, t91_order_status t91
	 WHERE t06.C06_ORDER_ID BETWEEN 1 AND 5
	   AND t91.C91_ORDER_STATUS_ID BETWEEN 1 AND 5

	UNION ALL

	SELECT C06_ORDER_ID ORDER_ID,
		   t91.C91_ORDER_STATUS_ID ORDER_STATUS_ID,
		   2 EMPLOYEE_ID,
		   DATE_SUB(current_timestamp(), INTERVAL (3 - t91.C91_ORDER_STATUS_ID) DAY) LAST_UPDATED
	  FROM t06_order t06, t91_order_status t91
	 WHERE t06.C06_ORDER_ID BETWEEN 6 AND 8
	   AND t91.C91_ORDER_STATUS_ID BETWEEN 1 AND 3
	   
	UNION ALL

	SELECT C06_ORDER_ID ORDER_ID,
		   t91.C91_ORDER_STATUS_ID ORDER_STATUS_ID,
		   3 EMPLOYEE_ID,
		   DATE_SUB(current_timestamp(), INTERVAL (4 - t91.C91_ORDER_STATUS_ID) DAY) LAST_UPDATED
	  FROM t06_order t06, t91_order_status t91
	 WHERE t06.C06_ORDER_ID BETWEEN 9 AND 10
	   AND t91.C91_ORDER_STATUS_ID BETWEEN 1 AND 4
	   
	UNION ALL

	SELECT C06_ORDER_ID ORDER_ID,
		   t91.C91_ORDER_STATUS_ID ORDER_STATUS_ID,
		   4 EMPLOYEE_ID,
		   DATE_SUB(current_timestamp(), INTERVAL (7 - t91.C91_ORDER_STATUS_ID) DAY) LAST_UPDATED
	  FROM t06_order t06, t91_order_status t91
	 WHERE t06.C06_ORDER_ID BETWEEN 11 AND 12
	   AND t91.C91_ORDER_STATUS_ID = 7
	   
	UNION ALL

	SELECT C06_ORDER_ID ORDER_ID,
		   t91.C91_ORDER_STATUS_ID ORDER_STATUS_ID,
		   5 EMPLOYEE_ID,
		   DATE_SUB(current_timestamp(), INTERVAL (6 - t91.C91_ORDER_STATUS_ID) DAY) LAST_UPDATED
	  FROM t06_order t06, t91_order_status t91
	 WHERE t06.C06_ORDER_ID = 13
	   AND t91.C91_ORDER_STATUS_ID IN (1,2,3,4,6)
)
SELECT * FROM CTE_ORDER_STATUS_DETAIL;


-- Với >__$$__< là tham số truyền vào

-- 3. Liệt kê toàn bộ thông tin các loại hàng
SELECT * FROM t02_item_group;

-- Áo, Quần, Giày
-- 1 2 3
-- 4. Liệt kê các mặt hàng thuộc loại hàng là >__$$__<
SELECT * 
  FROM t01_item 
 WHERE C01_ITEM_GROUP_ID IN (SELECT C02_ITEM_GROUP_ID
                              FROM t02_item_group 
							 WHERE C02_ITEM_GROUP_NAME IN ('Giày', 'Quần'));
                             
SELECT * 
  FROM t01_item t01
 WHERE EXISTS (SELECT 1
			     FROM t02_item_group t02
			    WHERE t02.C02_ITEM_GROUP_NAME IN ('Giày', 'Quần')
			      AND t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID);

-- 5. Liệt kê top 5 mặt hàng có giá bán cao nhất
-- giá bán: item, size
SELECT *
  FROM t14_item_detail
  ORDER BY C14_SALES_PRICE DESC, C14_ITEM_DETAIL_ID ASC
  LIMIT 5;
  
-- Yêu cầu: Liệt kê top 5 mặt hàng có giá bán trung bình cao nhất
-- Giá bán trung bình: trung bình giá bán tất cả các size của mặt hàng
-- ITEM 1 S 20
--      1 M 30
-- ==> Item 1 có giá trung bình là 25
-- ITEM 2 S 20
--      2 M 30
--      2 L 50
-- ==> Item 3 có giá trung bình là 33

SELECT C14_ITEM_ID ITEM_ID,
       AVG(C14_SALES_PRICE) AVG_SALES_PRICE
  FROM t14_item_detail
 WHERE C14_ITEM_ID = 1;
 
SELECT C14_ITEM_ID ITEM_ID,
       AVG(C14_SALES_PRICE) AVG_SALES_PRICE
  FROM t14_item_detail
 GROUP BY C14_ITEM_ID
 ORDER BY AVG(C14_SALES_PRICE) DESC, C14_ITEM_ID ASC
 LIMIT 5;

-- 6. Liệt kê toàn bộ đơn hàng
SELECT * FROM t06_order;

-- 7. Liệt kê các đơn hàng được bán trong ngày >__$$__<
SELECT * FROM t06_order WHERE cast(C06_ORDER_DATE AS DATE) = str_to_date('18/04/2026', '%d/%m/%Y');

-- 8. Liệt kê các đơn hàng được bán từ ngày >__$$1__< đến ngày >__$$2__<
SELECT * FROM t06_order WHERE cast(C06_ORDER_DATE AS DATE) BETWEEN '2026-04-01' AND '2026-04-16';

-- 9. Liệt kê các đơn hàng được bán trong tháng __mm/yyyy__
SELECT * FROM t06_order WHERE month(C06_ORDER_DATE) = 04 AND year(C06_ORDER_DATE) = 2026;

-- 10. Liệt kê các đơn hàng được giao tại >__$$__<
SELECT * FROM t06_order WHERE C06_DELIVERY_ADDRESS LIKE '%Địa chỉ 1%';

-- 11. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi >__$$__<, làm tròn 2 chữ số thập phân

-- 12. Giảm giá >__$$__< tất cả các mặt hàng trong ngày >__dd/mm/yyyy__<

-- 13. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.

-- 14. Liệt kê thông tin các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày >__dd/mm/yyyy__<

-- 15. Liệt kê các mặt hàng có giá bán từ >__$$1__< đến >__$$2__<

-- 16. Liệt kê tất cả các mặt hàng thuộc loại hàng là >__$$1__< và >__$$2__<

-- 17. Liệt kê các đơn hàng được đặt trong ngày (>__$$1__<, >__$$2__<)

-- 18. Sắp xếp các mặt hàng với giá bán tăng dần

-- 19. Sắp xếp các mặt hàng với giá mua giảm dần

-- 20. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần

-- 21. Đếm số lượng các mặt hàng trong hệ thống

-- 22. Số lượng 'Giày da Nam' được bán trong ngày >__$$__<
-- Table: item_group, sub_item_group
--        item_detail, order, order_detail

SELECT SUM(t16.C16_AMOUNT) TOTAL_OF_ITEMS
  FROM t06_order t06
  JOIN t16_order_detail t16
    ON t06.C06_ORDER_ID = t16.C16_ORDER_ID
  JOIN t14_item_detail t14
    ON t14.C14_ITEM_DETAIL_ID = t16.C16_ITEM_DETAIL_ID
  JOIN t01_item t01
	ON t01.C01_ITEM_ID = t14.C14_ITEM_ID
  LEFT JOIN t02_item_group t02
    ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID
  LEFT JOIN  t03_sub_item_group t03
    ON t01.C01_SIG_ID = t03.C03_SIG_ID
 WHERE cast(t06.C06_ORDER_DATE AS DATE) = str_to_date('18/04/2026', '%d/%m/%Y')
   AND t01.C01_ITEM_NAME = 'Giày'
    OR t02.C02_ITEM_GROUP_NAME = 'Giày'
    OR t03.C03_SIG_NAME = 'Giày';

-- 23. Đếm số lượng các mặt hàng theo từng loại hàng

-- 24. Tìm mặt hàng có giá bán cao nhất trong loại hàng >__$$__<
WITH CTE_MAX_PRICES AS(
	SELECT ig.C02_ITEM_GROUP_ID item_group_id,
           MAX(C14_SALES_PRICE) price
	FROM T01_ITEM  
    JOIN T14_ITEM_DETAIL  ON C01_ITEM_ID = C14_ITEM_ID
	JOIN T02_ITEM_GROUP ig ON ig.C02_ITEM_GROUP_ID = C01_ITEM_GROUP_ID
    WHERE ig.C02_ITEM_GROUP_NAME = 'Quần'
)
SELECT C01_ITEM_ID, C01_ITEM_NAME, C14_SALES_PRICE
  FROM T01_ITEM
  JOIN T14_ITEM_DETAIL ON C01_ITEM_ID = C14_ITEM_ID
  JOIN T02_ITEM_GROUP ig ON ig.C02_ITEM_GROUP_ID = C01_ITEM_GROUP_ID
  JOIN CTE_MAX_PRICES
    ON C14_SALES_PRICE = price
   AND ig.C02_ITEM_GROUP_ID = item_group_id;

-- 25. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
-- item_group --> item -> item_detail(item, size): sales_price

WITH CTE_ITEM_DETAILS AS (
	SELECT C14_ITEM_ID ITEM_ID,
       MAX(C14_SALES_PRICE) SALES_PRICE
	  FROM t14_item_detail
	 GROUP BY C14_ITEM_ID
), CTE_ITEM_GROUP_DETAILS AS (
   SELECT t01.C01_ITEM_GROUP_ID ITEM_GROUP_ID,
		  MAX(cte_itd.SALES_PRICE) MAX_ITEM_SALES_PRICE
	 FROM CTE_ITEM_DETAILS cte_itd
	 JOIN t01_item t01
	   ON cte_itd.ITEM_ID = t01.C01_ITEM_ID
	WHERE t01.C01_ITEM_GROUP_ID IS NOT NULL
	GROUP BY t01.C01_ITEM_GROUP_ID	
)
SELECT *
  FROM CTE_ITEM_GROUP_DETAILS cte_igd
  JOIN t01_item t01
    ON cte_igd.ITEM_GROUP_ID = t01.C01_ITEM_GROUP_ID
  JOIN CTE_ITEM_DETAILS cte_itd
    ON t01.C01_ITEM_ID = cte_itd.ITEM_ID
   AND cte_igd.MAX_ITEM_SALES_PRICE = cte_itd.SALES_PRICE;


-- 26. Tìm tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
-- Số lượng: COUNT, SUM
SELECT C01_ITEM_GROUP_ID ITEM_GROUP_ID,
       group_concat(C01_ITEM_NAME) LIST_OF_ITEMS,
       count(*) AMOUNT_OF_ITEMS
  FROM t01_item
 WHERE C01_ITEM_GROUP_ID IS NOT NULL
 GROUP BY C01_ITEM_GROUP_ID;
 
SELECT t01.C01_ITEM_GROUP_ID ITEM_GROUP_ID,
       sum(t14.C14_AMOUNT) AMOUNT_OF_ITEMS
  FROM t01_item t01
  JOIN t14_item_detail t14
    ON t01.C01_ITEM_ID = t14.C14_ITEM_ID
 WHERE t01.C01_ITEM_GROUP_ID IS NOT NULL
 GROUP BY t01.C01_ITEM_GROUP_ID; 

-- 27. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống, điều kiện tổng số lượng lớn hơn >__$$__< mặt hàng
SELECT t01.C01_ITEM_GROUP_ID ITEM_GROUP_ID,
       sum(t14.C14_AMOUNT) AMOUNT_OF_ITEMS
  FROM t01_item t01
  JOIN t14_item_detail t14
    ON t01.C01_ITEM_ID = t14.C14_ITEM_ID
 WHERE t01.C01_ITEM_GROUP_ID IS NOT NULL
 GROUP BY t01.C01_ITEM_GROUP_ID
 HAVING sum(t14.C14_AMOUNT) > 3000;

SET autocommit = 1;
rollback;

UPDATE t14_item_detail
  SET C14_AMOUNT = C14_AMOUNT + C14_ITEM_DETAIL_ID;

-- 28. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
WITH CTE_MAX_QUANTITY_PER_GROUP AS (
    SELECT 
        t01.C01_ITEM_GROUP_ID AS item_group_id,
        MAX(t14.C14_AMOUNT) AS max_amount
    FROM T01_ITEM t01
    JOIN T14_ITEM_DETAIL t14 ON t01.C01_ITEM_ID = t14.C14_ITEM_ID
    WHERE t01.C01_ITEM_GROUP_ID IS NOT NULL
    GROUP BY t01.C01_ITEM_GROUP_ID
)
SELECT 
    t01.C01_ITEM_GROUP_ID,
    t01.C01_ITEM_ID,
    t01.C01_ITEM_NAME,
    t14.C14_SIZE_ID,
    t14.C14_AMOUNT
FROM T01_ITEM t01
JOIN T14_ITEM_DETAIL t14 
  ON t01.C01_ITEM_ID = t14.C14_ITEM_ID
JOIN CTE_MAX_QUANTITY_PER_GROUP cte 
  ON t01.C01_ITEM_GROUP_ID = cte.item_group_id
 AND t14.C14_AMOUNT = cte.max_amount;

-- 29. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT t01.C01_ITEM_GROUP_ID item_group_id,
	   avg(C14_SALES_PRICE) avg_sales_price
  FROM t01_item t01
  JOIN t14_item_detail t14
    ON t01.C01_ITEM_ID = t14.C14_ITEM_ID
  WHERE t01.C01_ITEM_GROUP_ID IS NOT NULL
  GROUP BY t01.C01_ITEM_GROUP_ID;
    
-- 30. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT t01.C01_ITEM_GROUP_ID AS item_group_id,
       SUM(t14.C14_AMOUNT) AS amount
  FROM T01_ITEM t01
  JOIN T14_ITEM_DETAIL t14 ON t01.C01_ITEM_ID = t14.C14_ITEM_ID
 WHERE t01.C01_ITEM_GROUP_ID IS NOT NULL
 GROUP BY t01.C01_ITEM_GROUP_ID
 ORDER BY SUM(t14.C14_AMOUNT) DESC, t01.C01_ITEM_GROUP_ID ASC
 LIMIT 3;

-- 31. Liệt kê những mặt hàng có MaLoai = >__$$1__< và thuộc đơn hàng >__$$2__<
SELECT *
  FROM t01_item t01
  JOIN t14_item_detail t14 
    ON t01.C01_ITEM_ID = t14.C14_ITEM_ID
  JOIN t16_order_detail t16
    ON t14.C14_ITEM_DETAIL_ID = t16.C16_ITEM_DETAIL_ID
 WHERE t01.C01_ITEM_GROUP_ID = 1
   AND t16.C16_ORDER_ID = 11;

-- 32. Tìm những mặt hàng có Mã Loại = >__$$1__< và đã được bán trong ngày >__dd/mm__<
SELECT *
  FROM t01_item t01
  JOIN t14_item_detail t14 
    ON t01.C01_ITEM_ID = t14.C14_ITEM_ID
  JOIN t16_order_detail t16
    ON t14.C14_ITEM_DETAIL_ID = t16.C16_ITEM_DETAIL_ID
  JOIN t06_order t06
    ON t16.C16_ORDER_ID = t06.C06_ORDER_ID
 WHERE t01.C01_ITEM_GROUP_ID = 1
   AND cast(t06.C06_ORDER_DATE AS DATE) = '2026-04-20';

-- 33. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày >__d/m/y__<
-- 1 2 3     12
-- 1   3  6     13
SELECT t1.*
  FROM T01_ITEM t1
  JOIN T02_ITEM_GROUP t2 ON t1.C01_ITEM_GROUP_ID = t2.C02_ITEM_GROUP_ID
WHERE t2.C02_ITEM_GROUP_NAME = 'Áo'
  AND NOT EXISTS (
      SELECT 1
      FROM T14_ITEM_DETAIL t14
      INNER JOIN T16_ORDER_DETAIL t16 ON t14.C14_ITEM_DETAIL_ID = t16.C16_ITEM_DETAIL_ID
      INNER JOIN T06_ORDER t6 ON t16.C16_ORDER_ID = t6.C06_ORDER_ID
      WHERE DATE(t6.C06_ORDER_DATE) = '2026-04-20'
        AND t14.C14_ITEM_ID = t1.C01_ITEM_ID
  );

-- 34. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
-- Trường hợp sub query quá nhiều(>=3) lần thì có thể chuyển sang dùng JOIN cho code dễ đọc
UPDATE t14_item_detail
   SET C14_SALES_PRICE = 199
   WHERE C14_ITEM_ID IN ( SELECT C01_ITEM_ID
                             FROM t01_item
							WHERE C01_ITEM_GROUP_ID = ( SELECT C02_ITEM_GROUP_ID
														  FROM t02_item_group
														 WHERE C02_ITEM_GROUP_NAME = 'Áo'
                                                      )
							
						);
                        
UPDATE t14_item_detail t14
  JOIN t01_item t01
    ON t14.C14_ITEM_ID = t01.C01_ITEM_ID
  JOIN t02_item_group t02
    ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID
   AND t02.C02_ITEM_GROUP_NAME = 'Áo'
   SET C14_SALES_PRICE = 567;

-- 35. Backup data. Tạo table LoaiHang_SaoLuu(MaLoai, TenLoai), sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_SaoLuu
CREATE TABLE t02_temp_170926 (
	C02_TEMP_ID INT NOT NULL,
    C02_TEMP_NAME VARCHAR(255) NOT NULL,
    C02_TEMP_STATUS BIT(1) NOT NULL
);

INSERT INTO t02_temp_170926(C02_TEMP_ID, C02_TEMP_NAME, C02_TEMP_STATUS)
SELECT * FROM t02_item_group;

SELECT * FROM t02_temp_170926;

-- 36. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng >__$$1__< và >__$$2__<
SELECT t01.C01_ITEM_ID,
       -- t01.C01_ITEM_NAME,
       -- t02.C02_ITEM_GROUP_NAME,
       SUM(t14.C14_AMOUNT) AMOUNT
  FROM t14_item_detail t14
  JOIN t01_item t01
    ON t14.C14_ITEM_ID = t01.C01_ITEM_ID
  JOIN t02_item_group t02
    ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID
 WHERE t02.C02_ITEM_GROUP_NAME IN ('Áo', 'Quần')
 GROUP BY t14.C14_ITEM_ID
 ORDER BY SUM(t14.C14_AMOUNT) DESC, t01.C01_ITEM_ID ASC
 LIMIT 2;

-- 37. Tính tổng tiền cho đơn hàng 02, với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
SELECT  t16.C16_ORDER_ID ORDER_ID,
		round(sum(t14.C14_SALES_PRICE * t16.C16_AMOUNT), 2) TOTAL_OF_MONEY
  FROM t16_order_detail t16
  JOIN t14_item_detail t14
    ON t16.C16_ITEM_DETAIL_ID = t14.C14_ITEM_DETAIL_ID
 WHERE t16.C16_ORDER_ID = 2;

-- 38. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
-- SoDH
-- ChiTietDonHang = [TenMH:GiaBan:SoLuong]
-- TongTien
SELECT  t07.C07_BILL_ID BILL_ID,
		t16.C16_ORDER_ID ORDER_ID,
        group_concat('[', t01.C01_ITEM_NAME,':', t16.C16_AMOUNT,':', t14.C14_AMOUNT,']' SEPARATOR ', ') ORDER_DETAIL,
        t07.C07_DELIVERY_FEE DELIVERY_FEE,
		round(sum(t14.C14_SALES_PRICE * t16.C16_AMOUNT), 2) TOTAL_OF_MONEY
  FROM t16_order_detail t16
  JOIN t14_item_detail t14
    ON t16.C16_ITEM_DETAIL_ID = t14.C14_ITEM_DETAIL_ID
  JOIN t01_item t01
    ON t14.C14_ITEM_ID = t01.C01_ITEM_ID
  JOIN t07_bill t07
    ON t16.C16_ORDER_ID = t07.C07_ORDER_ID
 WHERE t16.C16_ORDER_ID = 2;
	
-- 39. Xuất thông tin hóa đơn của các đơn hàng có trong hệ thống với thông tin như sau.
-- SoDH
-- ChiTietDonHang = [TenMH:GiaBan:SoLuong]
-- TongTien
SELECT  t16.C16_ORDER_ID ORDER_ID,
        group_concat('[', t01.C01_ITEM_NAME,':', t14.C14_SALES_PRICE,':', t16.C16_AMOUNT,']' SEPARATOR ', ') ORDER_DETAIL,
        t07.C07_BILL_ID BILL_ID,
        t07.C07_DELIVERY_FEE DELIVERY_FEE,
		IF(t07.C07_BILL_ID IS NULL, NULL, round(sum(t14.C14_SALES_PRICE * t16.C16_AMOUNT), 2)) TOTAL_OF_MONEY
  FROM t16_order_detail t16
  JOIN t14_item_detail t14
    ON t16.C16_ITEM_DETAIL_ID = t14.C14_ITEM_DETAIL_ID
  JOIN t01_item t01
    ON t14.C14_ITEM_ID = t01.C01_ITEM_ID
  LEFT JOIN t07_bill t07
    ON t16.C16_ORDER_ID = t07.C07_ORDER_ID
 GROUP BY t16.C16_ORDER_ID;

-- 40. Cập nhật thông tin tổng tiền cho bảng T07_BILL
WITH cte_pre_bill AS (
	SELECT t16.C16_ORDER_ID ORDER_ID,
		   round(sum(t14.C14_SALES_PRICE * t16.C16_AMOUNT), 2) TOTAL_OF_MONEY
	  FROM t16_order_detail t16
	  JOIN t14_item_detail t14
		ON t16.C16_ITEM_DETAIL_ID = t14.C14_ITEM_DETAIL_ID
	  JOIN t07_bill t07
		ON t16.C16_ORDER_ID = t07.C07_ORDER_ID
	 GROUP BY t16.C16_ORDER_ID
)
UPDATE t07_bill t07
  JOIN cte_pre_bill cte
    ON t07.C07_ORDER_ID = cte.ORDER_ID
   SET C07_TOTAL_OF_MONEY = cte.TOTAL_OF_MONEY + t07.C07_DELIVERY_FEE;


