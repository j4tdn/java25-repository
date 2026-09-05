-- ======================= REFRESH DATA =======================

-- 1. Tạo dữ liệu kiểm thử cho bảng T07_BILL
INSERT INTO T07_BILL (C07_ORDER_ID, C07_DELIVERY_FEE, C07_TOTAL_OF_MONEY)
SELECT o.C06_ORDER_ID, 20 + FLOOR(RAND() * 4) * 10 AS DeliveryFee, 0 AS TotalOfMoney
FROM T06_ORDER o
WHERE o.C06_ORDER_ID NOT IN (11, 12);

-- 2. Tạo dữ liệu kiểm thử cho bảng T17_ORDER_STATUS_DETAIL
INSERT INTO T17_ORDER_STATUS_DETAIL (
    C17_ORDER_ID,
    C17_ORDER_STATUS_ID,
    C17_EMPLOYEE_ID,
    C17_LAST_UPDATED
)
SELECT o.C06_ORDER_ID,
       s.status_id,
       1,
       DATE_SUB(SYSDATE(), INTERVAL (5 - s.status_id) DAY)
FROM T06_ORDER o
JOIN (
    SELECT 1 AS status_id
    UNION ALL SELECT 2
    UNION ALL SELECT 3
    UNION ALL SELECT 4
    UNION ALL SELECT 5
) s
WHERE o.C06_ORDER_ID BETWEEN 1 AND 5;

INSERT INTO T17_ORDER_STATUS_DETAIL (
    C17_ORDER_ID,
    C17_ORDER_STATUS_ID,
    C17_EMPLOYEE_ID,
    C17_LAST_UPDATED
)
SELECT o.C06_ORDER_ID,
       s.status_id,
       2,
       DATE_SUB(SYSDATE(), INTERVAL (3 - s.status_id) DAY)
FROM T06_ORDER o
JOIN (
    SELECT 1 AS status_id
    UNION ALL SELECT 2
    UNION ALL SELECT 3
) s
WHERE o.C06_ORDER_ID BETWEEN 6 AND 8;

INSERT INTO T17_ORDER_STATUS_DETAIL (
    C17_ORDER_ID,
    C17_ORDER_STATUS_ID,
    C17_EMPLOYEE_ID,
    C17_LAST_UPDATED
)
SELECT o.C06_ORDER_ID,
       s.status_id,
       3,
       DATE_SUB(SYSDATE(), INTERVAL (4 - s.status_id) DAY)
FROM T06_ORDER o
JOIN (
    SELECT 1 AS status_id
    UNION ALL SELECT 2
    UNION ALL SELECT 3
    UNION ALL SELECT 4
) s
WHERE o.C06_ORDER_ID BETWEEN 9 AND 10;

INSERT INTO T17_ORDER_STATUS_DETAIL (
    C17_ORDER_ID,
    C17_ORDER_STATUS_ID,
    C17_EMPLOYEE_ID,
    C17_LAST_UPDATED
)
SELECT o.C06_ORDER_ID,
       7,
       4,
       DATE_SUB(SYSDATE(), INTERVAL (7 - 7) DAY)
FROM T06_ORDER o
WHERE o.C06_ORDER_ID IN (11, 12);

INSERT INTO T17_ORDER_STATUS_DETAIL (
    C17_ORDER_ID,
    C17_ORDER_STATUS_ID,
    C17_EMPLOYEE_ID,
    C17_LAST_UPDATED
)
SELECT 13,
       s.status_id,
       5,
       DATE_SUB(SYSDATE(), INTERVAL (6 - s.status_id) DAY)
FROM (
    SELECT 1 AS status_id
    UNION ALL SELECT 2
    UNION ALL SELECT 3
    UNION ALL SELECT 4
    UNION ALL SELECT 6
) s;
-- Với >__$$__< là tham số truyền vào

-- 3. Liệt kê toàn bộ thông tin các loại hàng
SELECT *
FROM T02_ITEM_GROUP;

-- 4. Liệt kê các mặt hàng thuộc loại hàng là 'Áo'
SELECT i.*
FROM T01_ITEM i
JOIN T02_ITEM_GROUP g
    ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
WHERE g.C02_ITEM_GROUP_NAME = 'Áo';

-- 5. Liệt kê top 5 mặt hàng có giá bán cao nhất
SELECT i.C01_ITEM_ID, i.C01_ITEM_NAME, MAX(d.C14_SALES_PRICE) AS GiaBanCaoNhat
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
GROUP BY i.C01_ITEM_ID,
         i.C01_ITEM_NAME
ORDER BY GiaBanCaoNhat DESC
LIMIT 5;

-- 6. Liệt kê toàn bộ đơn hàng
SELECT *
FROM T06_ORDER;

-- 7. Liệt kê các đơn hàng được bán trong ngày 10/04/2026
SELECT *
FROM T06_ORDER
WHERE DATE(C06_ORDER_DATE) = STR_TO_DATE('10/04/2026', '%d/%m/%Y');

-- 8. Liệt kê các đơn hàng được bán từ ngày 10/04/2026 đến ngày 20/04/2026
SELECT *
FROM T06_ORDER
WHERE DATE(C06_ORDER_DATE) BETWEEN STR_TO_DATE('10/04/2026', '%d/%m/%Y') AND STR_TO_DATE('20/04/2026', '%d/%m/%Y');

-- 9. Liệt kê các đơn hàng được bán trong tháng 04/2026
SELECT *
FROM T06_ORDER
WHERE DATE_FORMAT(C06_ORDER_DATE, '%m/%Y') = '04/2026';

-- 10. Liệt kê các đơn hàng được giao tại 'Địa chỉ 1'
SELECT *
FROM T06_ORDER
WHERE C06_DELIVERY_ADDRESS LIKE CONCAT('%', 'Địa chỉ 1', '%');

-- 11. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 10%, làm tròn 2 chữ số thập phân
SELECT C14_ITEM_DETAIL_ID, C14_ITEM_ID, C14_SIZE_ID, C14_SALES_PRICE AS GiaGoc, ROUND(C14_SALES_PRICE * (1 - 10 / 100), 2) AS GiaSauKhuyenMai
FROM T14_ITEM_DETAIL;

-- 12. Giảm giá 10% tất cả các mặt hàng trong ngày 12/04/2026 (mặt hàng đã bán trong ngày đó)
UPDATE T14_ITEM_DETAIL d
JOIN T16_ORDER_DETAIL od
    ON od.C16_ITEM_DETAIL_ID = d.C14_ITEM_DETAIL_ID
JOIN T06_ORDER o
    ON o.C06_ORDER_ID = od.C16_ORDER_ID
SET d.C14_SALES_PRICE = ROUND(d.C14_SALES_PRICE * (1 - 10 / 100), 2)
WHERE DATE(o.C06_ORDER_DATE) = STR_TO_DATE('12/04/2026', '%d/%m/%Y');

-- 13. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng
SELECT DISTINCT i.C01_COLOR
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID;

-- 14. Liệt kê thông tin các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 12/04/2026
SELECT DISTINCT
       i.C01_ITEM_ID AS MaMH,
       i.C01_ITEM_NAME AS TenMH,
       o.C06_ORDER_DATE AS ThoiGianDatHang
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
JOIN T16_ORDER_DETAIL od
    ON od.C16_ITEM_DETAIL_ID = d.C14_ITEM_DETAIL_ID
JOIN T06_ORDER o
    ON o.C06_ORDER_ID = od.C16_ORDER_ID
WHERE DATE(o.C06_ORDER_DATE) = STR_TO_DATE('12/04/2026', '%d/%m/%Y');

-- 15. Liệt kê các mặt hàng có giá bán từ 100 đến 300
SELECT DISTINCT i.*
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
WHERE d.C14_SALES_PRICE BETWEEN 100 AND 300;

-- 16. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Áo' và 'Quần'
SELECT i.*
FROM T01_ITEM i
JOIN T02_ITEM_GROUP g
    ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
WHERE g.C02_ITEM_GROUP_NAME IN ('Áo', 'Quần');

-- 17. Liệt kê các đơn hàng được đặt trong ngày (12/04/2026, 14/04/2026)
SELECT *
FROM T06_ORDER
WHERE DATE(C06_ORDER_DATE) IN (
    STR_TO_DATE('12/04/2026', '%d/%m/%Y'),
    STR_TO_DATE('14/04/2026', '%d/%m/%Y')
);

-- 18. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT i.C01_ITEM_ID, i.C01_ITEM_NAME, d.C14_SALES_PRICE
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
ORDER BY d.C14_SALES_PRICE ASC;

-- 19. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT C01_ITEM_ID, C01_ITEM_NAME, C01_BUY_PRICE
FROM T01_ITEM
ORDER BY C01_BUY_PRICE DESC;

-- 20. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT i.C01_ITEM_ID, i.C01_ITEM_NAME, i.C01_BUY_PRICE, d.C14_SALES_PRICE
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
ORDER BY d.C14_SALES_PRICE ASC,
         i.C01_BUY_PRICE DESC;

-- 21. Đếm số lượng các mặt hàng trong hệ thống
SELECT COUNT(*) AS SoLuongMatHang
FROM T01_ITEM;

-- 22. Số lượng 'Giày da Nam' được bán trong ngày 10/04/2026
SELECT IFNULL(SUM(od.C16_AMOUNT), 0) AS SoLuongBan
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
JOIN T16_ORDER_DETAIL od
    ON od.C16_ITEM_DETAIL_ID = d.C14_ITEM_DETAIL_ID
JOIN T06_ORDER o
    ON o.C06_ORDER_ID = od.C16_ORDER_ID
WHERE i.C01_ITEM_NAME = 'Giày da Nam'
  AND DATE(o.C06_ORDER_DATE) = STR_TO_DATE('10/04/2026', '%d/%m/%Y');

-- 23. Đếm số lượng các mặt hàng theo từng loại hàng
SELECT g.C02_ITEM_GROUP_NAME, COUNT(i.C01_ITEM_ID) AS SoLuongMatHang
FROM T02_ITEM_GROUP g
LEFT JOIN T01_ITEM i
    ON i.C01_ITEM_GROUP_ID = g.C02_ITEM_GROUP_ID
GROUP BY g.C02_ITEM_GROUP_ID,
         g.C02_ITEM_GROUP_NAME;

-- 24. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT i.C01_ITEM_ID, i.C01_ITEM_NAME, MAX(d.C14_SALES_PRICE) AS GiaBanCaoNhat
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
JOIN T02_ITEM_GROUP g
    ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
WHERE g.C02_ITEM_GROUP_NAME = 'Giày'
GROUP BY i.C01_ITEM_ID,
         i.C01_ITEM_NAME
ORDER BY GiaBanCaoNhat DESC
LIMIT 1;

-- 25. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
WITH CTE_MAX_PRICE AS (
    SELECT i.C01_ITEM_GROUP_ID,
           MAX(d.C14_SALES_PRICE) AS MaxPrice
    FROM T01_ITEM i
    JOIN T14_ITEM_DETAIL d
        ON d.C14_ITEM_ID = i.C01_ITEM_ID
    GROUP BY i.C01_ITEM_GROUP_ID
)
SELECT g.C02_ITEM_GROUP_NAME,
       i.C01_ITEM_ID,
       i.C01_ITEM_NAME,
       d.C14_SALES_PRICE
FROM T01_ITEM i
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
JOIN CTE_MAX_PRICE c
    ON c.C01_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID
   AND c.MaxPrice = d.C14_SALES_PRICE
JOIN T02_ITEM_GROUP g
    ON g.C02_ITEM_GROUP_ID = i.C01_ITEM_GROUP_ID;

-- 26. Tìm tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
SELECT g.C02_ITEM_GROUP_NAME, SUM(d.C14_AMOUNT) AS TongSoLuong
FROM T02_ITEM_GROUP g
JOIN T01_ITEM i
    ON i.C01_ITEM_GROUP_ID = g.C02_ITEM_GROUP_ID
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
GROUP BY g.C02_ITEM_GROUP_ID,
         g.C02_ITEM_GROUP_NAME;

-- 27. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng, điều kiện tổng số lượng > 500 mặt hàng
SELECT g.C02_ITEM_GROUP_NAME, SUM(d.C14_AMOUNT) AS TongSoLuong
FROM T02_ITEM_GROUP g
JOIN T01_ITEM i
    ON i.C01_ITEM_GROUP_ID = g.C02_ITEM_GROUP_ID
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
GROUP BY g.C02_ITEM_GROUP_ID,
         g.C02_ITEM_GROUP_NAME
HAVING SUM(d.C14_AMOUNT) > 500;

-- 28. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
WITH CTE_ITEM_AMOUNT AS (
    SELECT i.C01_ITEM_ID,
           i.C01_ITEM_GROUP_ID,
           i.C01_ITEM_NAME,
           SUM(d.C14_AMOUNT) AS TotalAmount
    FROM T01_ITEM i
    JOIN T14_ITEM_DETAIL d
        ON d.C14_ITEM_ID = i.C01_ITEM_ID
    GROUP BY i.C01_ITEM_ID,
             i.C01_ITEM_GROUP_ID,
             i.C01_ITEM_NAME
),
CTE_MAX_AMOUNT AS (
    SELECT C01_ITEM_GROUP_ID,
           MAX(TotalAmount) AS MaxAmount
    FROM CTE_ITEM_AMOUNT
    GROUP BY C01_ITEM_GROUP_ID
)
SELECT g.C02_ITEM_GROUP_NAME,
       a.C01_ITEM_NAME,
       a.TotalAmount
FROM CTE_ITEM_AMOUNT a
JOIN CTE_MAX_AMOUNT m
    ON m.C01_ITEM_GROUP_ID = a.C01_ITEM_GROUP_ID
   AND m.MaxAmount = a.TotalAmount
JOIN T02_ITEM_GROUP g
    ON g.C02_ITEM_GROUP_ID = a.C01_ITEM_GROUP_ID;

-- 29. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT g.C02_ITEM_GROUP_NAME, ROUND(AVG(d.C14_SALES_PRICE), 2) AS GiaBanTrungBinh
FROM T02_ITEM_GROUP g
JOIN T01_ITEM i
    ON i.C01_ITEM_GROUP_ID = g.C02_ITEM_GROUP_ID
JOIN T14_ITEM_DETAIL d
    ON d.C14_ITEM_ID = i.C01_ITEM_ID
GROUP BY g.C02_ITEM_GROUP_ID,
         g.C02_ITEM_GROUP_NAME;

-- 30. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
WITH CTE_ITEM_STOCK AS (
    SELECT i.C01_ITEM_ID, i.C01_ITEM_GROUP_ID, SUM(d.C14_AMOUNT) AS NhapKho
    FROM T01_ITEM i
    JOIN T14_ITEM_DETAIL d
        ON d.C14_ITEM_ID = i.C01_ITEM_ID
    GROUP BY i.C01_ITEM_ID,
             i.C01_ITEM_GROUP_ID
),
CTE_ITEM_SOLD AS (
    SELECT d.C14_ITEM_ID AS ItemId, SUM(od.C16_AMOUNT) AS DaBan
    FROM T16_ORDER_DETAIL od
    JOIN T14_ITEM_DETAIL d
        ON d.C14_ITEM_DETAIL_ID = od.C16_ITEM_DETAIL_ID
    GROUP BY d.C14_ITEM_ID
),
CTE_GROUP_STOCK AS (
    SELECT s.C01_ITEM_GROUP_ID, SUM(s.NhapKho - IFNULL(so.DaBan, 0)) AS ConLai
    FROM CTE_ITEM_STOCK s
    LEFT JOIN CTE_ITEM_SOLD so
        ON so.ItemId = s.C01_ITEM_ID
    GROUP BY s.C01_ITEM_GROUP_ID
)
SELECT g.C02_ITEM_GROUP_NAME, gs.ConLai
FROM CTE_GROUP_STOCK gs
JOIN T02_ITEM_GROUP g
    ON g.C02_ITEM_GROUP_ID = gs.C01_ITEM_GROUP_ID
ORDER BY gs.ConLai DESC
LIMIT 3;

-- 31. Liệt kê những mặt hàng có MaLoai = >__$$1__< và thuộc đơn hàng >__$$2__<

-- 32. Tìm những mặt hàng có Mã Loại = >__$$1__< và đã được bán trong ngày >__dd/mm__<

-- 33. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày >__d/m/y__<

-- 34. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
-- 35. Backup data. Tạo table LoaiHang_SaoLuu(MaLoai, TenLoai), sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_SaoLuu

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
