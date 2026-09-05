-- ======================= REFRESH DATA =======================

-- 1. Tạo dữ liệu kiểm thử cho bảng T07_BILL
INSERT INTO T07_BILL (C07_ORDER_ID, C7_TOTAL_OF_MONEY, C07_DELIVERY_FEE)
SELECT 
    C06_ORDER_ID,
    0 AS C7_TOTAL_OF_MONEY,
    ELT(f_random(1, 4), 20, 30, 40, 50) AS C07_DELIVERY_FEE
FROM T06_ORDER
WHERE C06_ORDER_ID NOT IN (11, 12);

SELECT * FROM T07_BILL;

-- 2. Tạo dữ liệu kiểm thử cho bảng T17_ORDER_STATUS_DETAIL
INSERT INTO T17_ORDER_STATUS_DETAIL (C17_ORDER_ID, C17_ORDER_STATUS_ID, C17_EMPLOYEE_ID, C17_LAST_UPDATED)
-- DH 1-5
SELECT 
    o.C06_ORDER_ID,
    st.status_id,
    1 AS C17_EMPLOYEE_ID,
    DATE_SUB(NOW(), INTERVAL (5 - st.status_id) DAY) AS C17_LAST_UPDATED
FROM T06_ORDER o
CROSS JOIN (
    SELECT 1 AS status_id UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5
) st
WHERE o.C06_ORDER_ID BETWEEN 1 AND 5

UNION ALL

-- DH 6-8
SELECT 
    o.C06_ORDER_ID,
    st.status_id,
    2 AS C17_EMPLOYEE_ID,
    DATE_SUB(NOW(), INTERVAL (3 - st.status_id) DAY) AS C17_LAST_UPDATED
FROM T06_ORDER o
CROSS JOIN (
    SELECT 1 AS status_id UNION ALL SELECT 2 UNION ALL SELECT 3
) st
WHERE o.C06_ORDER_ID BETWEEN 6 AND 8

UNION ALL

-- DH 9-10
SELECT 
    o.C06_ORDER_ID,
    st.status_id,
    3 AS C17_EMPLOYEE_ID,
    DATE_SUB(NOW(), INTERVAL (4 - st.status_id) DAY) AS C17_LAST_UPDATED
FROM T06_ORDER o
CROSS JOIN (
    SELECT 1 AS status_id UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4
) st
WHERE o.C06_ORDER_ID BETWEEN 9 AND 10

UNION ALL

-- DH 11-12
SELECT 
    o.C06_ORDER_ID,
    7 AS status_id,
    4 AS C17_EMPLOYEE_ID,
    NOW() AS C17_LAST_UPDATED
FROM T06_ORDER o
WHERE o.C06_ORDER_ID IN (11, 12)

UNION ALL

-- DH 13
SELECT 
    o.C06_ORDER_ID,
    st.status_id,
    5 AS C17_EMPLOYEE_ID,
    DATE_SUB(NOW(), INTERVAL (6 - st.status_id) DAY) AS C17_LAST_UPDATED
FROM T06_ORDER o
CROSS JOIN (
    SELECT 1 AS status_id UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 6
) st
WHERE o.C06_ORDER_ID = 13;

SELECT * FROM T17_ORDER_STATUS_DETAIL;

-- Với >__$$__< là tham số truyền vào

-- 3. Liệt kê toàn bộ thông tin các loại hàng
SELECT * FROM t02_item_group;

-- 4. Liệt kê các mặt hàng thuộc loại hàng là >__Áo__<
SELECT i.*
FROM T02_ITEM_GROUP g
JOIN T01_ITEM i ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
WHERE g.C02_ITEM_GROUP_NAME = "Áo";

-- 5. Liệt kê top 5 mặt hàng có giá bán cao nhất
SELECT DISTINCT 
    i.C01_ITEM_ID, 
    i.C01_ITEM_NAME, 
    id.C14_SALES_PRICE
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL id ON i.C01_ITEM_ID = id.C14_ITEM_ID
ORDER BY id.C14_SALES_PRICE DESC
LIMIT 5;

-- 6. Liệt kê toàn bộ đơn hàng
SELECT * FROM T06_ORDER;

-- 7. Liệt kê các đơn hàng được bán trong ngày >__2026-04-18__<
SELECT * FROM T06_ORDER
WHERE DATE(C06_ORDER_DATE) = "2026-04-18";

-- 8. Liệt kê các đơn hàng được bán từ ngày >__2026-04-18__< đến ngày >__2026-04-18__<
SELECT * FROM T06_ORDER
WHERE DATE(C06_ORDER_DATE) BETWEEN "2026-04-10" AND "2026-04-18";

-- 9. Liệt kê các đơn hàng được bán trong tháng __3/2026__
SELECT * FROM T06_ORDER
WHERE 
	MONTH(C06_ORDER_DATE) = "3"
    AND YEAR(C06_ORDER_DATE) = "2026";

-- 10. Liệt kê các đơn hàng được giao tại >__Địa chỉ 1__<
SELECT * FROM T06_ORDER
WHERE C06_DELIVERY_ADDRESS = "Địa chỉ 1";

-- 11. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi >__10%__<, làm tròn 2 chữ số thập phân
SELECT 
    i.C01_ITEM_ID,
    i.C01_ITEM_NAME,
    id.C14_ITEM_DETAIL_ID,
    id.C14_SALES_PRICE AS BEFORE_SALE,
    ROUND(id.C14_SALES_PRICE * 0.9, 2) AS AFTER_SALE
FROM T14_ITEM_DETAIL id
JOIN T01_ITEM i ON id.C14_ITEM_ID = i.C01_ITEM_ID;

-- 12. Giảm giá >__10%__< tất cả các mặt hàng trong ngày >__2026-04-18__<
SELECT 
    o.C06_ORDER_ID,
    o.C06_ORDER_DATE,
    i.C01_ITEM_NAME,
	id.C14_SALES_PRICE AS BEFORE_SALE,
    ROUND(id.C14_SALES_PRICE * 0.9, 2) AS AFTER_SALE
FROM T06_ORDER o
JOIN T16_ORDER_DETAIL od ON o.C06_ORDER_ID = od.C16_ORDER_ID
JOIN T14_ITEM_DETAIL id ON od.C16_ITEM_DETAIL_ID = id.C14_ITEM_DETAIL_ID
JOIN T01_ITEM i ON id.C14_ITEM_ID = i.C01_ITEM_ID
WHERE DATE(C06_ORDER_DATE) = "2026-04-18";

-- 13. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT C01_COLOR 
FROM T01_ITEM;

-- 14. Liệt kê thông tin các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày >__d2026-04-18__<
SELECT DISTINCT
    i.C01_ITEM_ID AS MaMH,
    i.C01_ITEM_NAME AS TenMH,
    o.C06_ORDER_DATE AS ThoiGianDatHang
FROM T06_ORDER o
JOIN T16_ORDER_DETAIL od ON o.C06_ORDER_ID = od.C16_ORDER_ID
JOIN T14_ITEM_DETAIL id ON od.C16_ITEM_DETAIL_ID = id.C14_ITEM_DETAIL_ID
JOIN T01_ITEM i ON id.C14_ITEM_ID = i.C01_ITEM_ID
WHERE DATE(C06_ORDER_DATE) = "2026-04-18";

-- 15. Liệt kê các mặt hàng có giá bán từ >__390__< đến >__400__<
SELECT DISTINCT 
    i.C01_ITEM_ID, 
    i.C01_ITEM_NAME, 
    id.C14_SALES_PRICE
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL id ON i.C01_ITEM_ID = id.C14_ITEM_ID
WHERE id.C14_SALES_PRICE BETWEEN 390 AND 400;

-- 16. Liệt kê tất cả các mặt hàng thuộc loại hàng là >__Áo__< và >__Quần__<
SELECT i.*
FROM T02_ITEM_GROUP g
JOIN T01_ITEM i ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
WHERE g.C02_ITEM_GROUP_NAME IN("Áo", "Quần") ;

-- 17. Liệt kê các đơn hàng được đặt trong ngày (>__$$1__<, >__$$2__<)
SELECT * 
FROM T06_ORDER
WHERE DATE(C06_ORDER_DATE) IN ("2026-04-10", "2026-04-18");

-- 18. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT 
    i.C01_ITEM_ID, 
    i.C01_ITEM_NAME, 
    id.C14_SALES_PRICE
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL id ON i.C01_ITEM_ID = id.C14_ITEM_ID
ORDER BY id.C14_SALES_PRICE ASC;

-- 19. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT 
    i.C01_ITEM_ID, 
    i.C01_ITEM_NAME, 
    id.C14_SALES_PRICE
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL id ON i.C01_ITEM_ID = id.C14_ITEM_ID
ORDER BY id.C14_SALES_PRICE DESC;

-- 20. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT 
    i.C01_ITEM_ID, 
    i.C01_ITEM_NAME, 
    id.C14_SALES_PRICE, 
    i.C01_BUY_PRICE
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL id ON i.C01_ITEM_ID = id.C14_ITEM_ID
ORDER BY id.C14_SALES_PRICE ASC, 
		 i.C01_BUY_PRICE DESC;

-- 21. Đếm số lượng các mặt hàng trong hệ thống
SELECT COUNT(*) AS COUNT_ITEM 
FROM T01_ITEM;

-- 22. Số lượng 'Giày da Nam' được bán trong ngày >__2026-04-18__<
SELECT 
    SUM(od.C16_AMOUNT) AS COUNT_SELL_ITEM
FROM T06_ORDER o
JOIN T16_ORDER_DETAIL od ON o.C06_ORDER_ID = od.C16_ORDER_ID
JOIN T14_ITEM_DETAIL id ON od.C16_ITEM_DETAIL_ID = id.C14_ITEM_DETAIL_ID
JOIN T01_ITEM i ON id.C14_ITEM_ID = i.C01_ITEM_ID
JOIN T04_SIZE s ON id.C14_SIZE_ID = s.C04_SIZE_ID
WHERE i.C01_ITEM_NAME = "Giày" 
  AND s.C04_GENDER = 1
  AND DATE(o.C06_ORDER_DATE) = 2026-04-18;

-- 23. Đếm số lượng các mặt hàng theo từng loại hàng


-- 24. Tìm mặt hàng có giá bán cao nhất trong loại hàng >__Áo_<
SELECT 
    i.C01_ITEM_ID, 
    i.C01_ITEM_NAME, 
    id.C14_SALES_PRICE
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL id ON i.C01_ITEM_ID = id.C14_ITEM_ID
JOIN T02_ITEM_GROUP g ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
WHERE g.C02_ITEM_GROUP_NAME = "Áo"
ORDER BY id.C14_SALES_PRICE DESC
LIMIT 1;

-- 25. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng


-- 26. Tìm tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
SELECT 
    g.C02_ITEM_GROUP_ID,
    g.C02_ITEM_GROUP_NAME,
    SUM(id.C14_AMOUNT) AS SUM_AMOUNT
FROM T02_ITEM_GROUP g
JOIN T01_ITEM i ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
JOIN T14_ITEM_DETAIL id ON i.C01_ITEM_ID = id.C14_ITEM_ID
GROUP BY g.C02_ITEM_GROUP_ID, g.C02_ITEM_GROUP_NAME;

-- 27. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống, điều kiện tổng số lượng >__$$__< mặt hàng


-- 28. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng


-- 29. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT 
    g.C02_ITEM_GROUP_ID,
    g.C02_ITEM_GROUP_NAME,
    ROUND(AVG(id.C14_SALES_PRICE), 2) AS AVG_PRICE
FROM T02_ITEM_GROUP g
JOIN T01_ITEM i ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
JOIN T14_ITEM_DETAIL id ON i.C01_ITEM_ID = id.C14_ITEM_ID
GROUP BY g.C02_ITEM_GROUP_ID, g.C02_ITEM_GROUP_NAME;

-- 30. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT 
    g.C02_ITEM_GROUP_ID,
    g.C02_ITEM_GROUP_NAME,
    SUM(id.C14_AMOUNT) AS TONG_SO_LUONG_CON_LAI
FROM T02_ITEM_GROUP g
JOIN T01_ITEM i ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
JOIN T14_ITEM_DETAIL id ON i.C01_ITEM_ID = id.C14_ITEM_ID
GROUP BY g.C02_ITEM_GROUP_ID, g.C02_ITEM_GROUP_NAME
ORDER BY TONG_SO_LUONG_CON_LAI DESC
LIMIT 3;

-- 31. Liệt kê những mặt hàng có MaLoai = >__$$1__< và thuộc đơn hàng >__$$2__<

-- 32. Tìm những mặt hàng có Mã Loại = >__$$1__< và đã được bán trong ngày >__dd/mm__<

-- 33. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày >__d/m/y__<

-- 34. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199

-- 35. Backup data. Tạo table LoaiHang_SaoLuu(MaLoai, TenLoai), sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_SaoLuu
DROP TABLE IF EXISTS LoaiHang_SaoLuu;
CREATE TABLE LoaiHang_SaoLuu (
    MaLoai INT PRIMARY KEY,
    TenLoai VARCHAR(255)
);

INSERT INTO LoaiHang_SaoLuu (MaLoai, TenLoai)
SELECT C02_ITEM_GROUP_ID, C02_ITEM_GROUP_NAME 
FROM T02_ITEM_GROUP;

SELECT * FROM LoaiHang_SaoLuu

-- 36. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng >__$$1__< và >__$$2__<

-- 37. Tính tổng tiền cho đơn hàng 02, với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng

-- 38. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
-- SoDH
-- ChiTietDonHang = [TenMH:GiaBan:SoLuong]
-- TongTien
	
-- 39. Xuất thông tin hóa đơn của các đơn hàng có trong hệ thống với thông tin như sau.
-- SoDH
-- ChiTietDonHang = [TenMH:GiaBan:SoLuong]
-- TongTien

-- 40. Cập nhật thông tin tổng tiền cho bảng T07_BILL

