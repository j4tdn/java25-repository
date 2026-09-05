-- DML

-- SELECT ALL
SELECT * FROM t01_item; -- 7 items
SELECT * FROM t02_item_group;
SELECT * FROM t03_sub_item_group;
SELECT * FROM t04_size; -- 6 sizes


-- SELECT
SELECT * FROM t01_item;
SELECT t01.C01_ITEM_ID   ITEM_ID,
       t01.C01_ITEM_NAME ITEM_NAME,
       t04.C04_SIZE_ID   SIZE_ID,
       t04.C04_SIZE_NAME SIZE_NAME
  FROM t01_item t01, t04_size t04;
SELECT *,
       ROUND(C01_BUY_PRICE * 105 / 100, 2) BUY_PRICE_WITH_TAX
  FROM t01_item;
  
-- DISTINCT - LIMIT
SELECT * FROM t03_sub_item_group;
SELECT DISTINCT C03_ITEM_GROUP_ID, C03_SIG_NAME FROM t03_sub_item_group;

SELECT * FROM t01_item;
SELECT DISTINCT C01_MATERIAL, C01_COLOR, C01_ITEM_GROUP_ID FROM t01_item;

-- offset  : vị trí dòng bắt đầu muốn lấy [inclusive <=> 0 as default
-- rowcount: số dòng muốn lấy tính từ offset
-- [offset, rowcount)

-- pagination, top ... with a condition
SELECT * 
  FROM t01_item
 LIMIT 1, 3;
 
-- liệt kê 3 mặt hàng có giá mua lớn nhất
-- vn: những mặt hàng có giá mua lớn nhất lại trùng nhau

-- TH1: Chỉ thật sự cần 3 dòng đầu tiên --> cần tiêu chí phụ thứ 2 cho sort order
SELECT *
  FROM t01_item
 ORDER BY C01_BUY_PRICE DESC, C01_ITEM_ID ASC
 LIMIT 3;

-- TH2: Lấy tất cả các mặt hàng có giá mua nằm trong top 3
-- B1: Tìm top 3 giá bán cao nhất có trong bảng mặt hàng
-- B2: Liệt kê các mặt hàng có giá bán = giá bán trong B1
WITH cte_top_3_prices AS (
	SELECT DISTINCT C01_BUY_PRICE VAL
	  FROM t01_item
	 ORDER BY C01_BUY_PRICE DESC
	 LIMIT 3
)
SELECT *
  FROM t01_item
 WHERE C01_BUY_PRICE IN (SELECT VAL FROM cte_top_3_prices) -- replace IN by EXISTS || JOIN
 ORDER BY C01_BUY_PRICE DESC;
 
-- case/when
SELECT C02_ITEM_GROUP_ID ITEM_GROUP_ID,
       C02_ITEM_GROUP_NAME ITEM_GROUP_NAME,
       CASE C02_STATUS
		    WHEN 0 THEN 'INACTIVE'
            WHEN 1 THEN 'ACTIVE'
			ELSE 'INVALID'
		END `STATUS`
  FROM t02_item_group;
  
SELECT C02_ITEM_GROUP_ID ITEM_GROUP_ID,
       C02_ITEM_GROUP_NAME ITEM_GROUP_NAME,
       CASE 
		    WHEN C02_STATUS = 0 THEN 'INACTIVE'
            WHEN C02_STATUS = 1 THEN 'ACTIVE'
			-- [ELSE 'INVALID']
		END `STATUS`
  FROM t02_item_group;

SELECT C02_ITEM_GROUP_ID ITEM_GROUP_ID,
       C02_ITEM_GROUP_NAME ITEM_GROUP_NAME,
       IF(C02_STATUS = 0, 'INACTIVE', 'ACTIVE') `STATUS`
  FROM t02_item_group;
  
-- logical conditions  
SELECT *
  FROM t02_item_group
 WHERE C02_ITEM_GROUP_ID BETWEEN 5 AND 10;
 
SELECT *
  FROM t02_item_group
 WHERE C02_ITEM_GROUP_ID NOT BETWEEN 5 AND 10; 
 
SELECT *
  FROM t02_item_group
 WHERE C02_ITEM_GROUP_ID IN (5, 7, 9); 
 
SELECT *
  FROM t02_item_group
 WHERE C02_ITEM_GROUP_NAME LIKE 'Loại Hàng 1%';
 
SELECT @@sql_mode;
SET @@sql_mode = sys.list_drop(@@sql_mode,'ONLY_FULL_GROUP_BY');
SET @@sql_mode = sys.list_add(@@sql_mode,'ONLY_FULL_GROUP_BY');

-- group by / having 
SELECT *
  FROM t01_item;
  
SELECT C01_ITEM_ID ITEM_ID,
       C01_ITEM_NAME ITEM_NAME,
       C01_ITEM_GROUP_ID GROUP_ID
  FROM t01_item;

-- no only_full_group_by
-- báo lỗi khi select columns ko nằm trong group by
SELECT -- C01_ITEM_ID ITEM_ID,
       -- C01_ITEM_NAME ITEM_NAME,
       C01_ITEM_GROUP_ID GROUP_ID,
       COUNT(*) AMOUNT_OF_ITEMS,
       GROUP_CONCAT(C01_ITEM_NAME ORDER BY C01_ITEM_ID DESC SEPARATOR ', ') DETAILS
  FROM t01_item
 GROUP BY C01_ITEM_GROUP_ID;
 
-- Tìm giá mua trung bình các mặt hàng trong mỗi loại hàng 
SELECT C01_ITEM_GROUP_ID GROUP_ID,
       GROUP_CONCAT(CONCAT(C01_ITEM_NAME, '[', C01_BUY_PRICE, ']') ORDER BY C01_ITEM_ID DESC SEPARATOR ', ') LIST_OF_ITEMS,
       AVG(C01_BUY_PRICE) PRICE_IN_AVG
  FROM t01_item
 GROUP BY C01_ITEM_GROUP_ID
 HAVING AVG(C01_BUY_PRICE) >= 200 AND COUNT(*) >= 2;
 
-- UNION
SELECT C01_ITEM_GROUP_ID FROM t01_item WHERE C01_SIG_ID IS NOT NULL
UNION
SELECT C03_ITEM_GROUP_ID FROM t03_sub_item_group WHERE C03_ITEM_GROUP_ID > 3;

-- JOIN
-- INNER/LEFT/RIGHT/OUTER/CROSS/SELF
SELECT * FROM t01_item; -- 1 20 21 22
SELECT * FROM t02_item_group; -- 100 records

SELECT t01.*,
       t02.C02_ITEM_GROUP_NAME,
       t02.C02_STATUS
  FROM t01_item t01
  JOIN t02_item_group t02 ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID;

-- Liệt kê những loại hàng ko có mặt hàng nào cả  
SELECT t01.*,
       t02.C02_ITEM_GROUP_NAME,
       t02.C02_STATUS
  FROM t01_item t01
  RIGHT JOIN t02_item_group t02 ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID
  WHERE t01.C01_ITEM_GROUP_ID IS NULL;

-- CROSS JOIN  
SELECT COUNT(*)
  FROM t01_item t01
  JOIN t02_item_group t02;

SELECT COUNT(*)
  FROM t01_item t01, t02_item_group t02;
  
-- SELF, DEMO
  
  
  


 

 
 
 

 
