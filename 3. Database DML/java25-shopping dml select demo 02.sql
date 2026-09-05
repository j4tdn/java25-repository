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