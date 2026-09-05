-- ======================= REFRESH DATA =======================

-- 1. Tạo dữ liệu kiểm thử cho bảng T07_BILL
INSERT INTO T07_BILL(C07_ORDER_ID, C07_TOTAL_OF_MONEY, C07_DELIVERY_FEE)
WITH CTE_ORDER_DETAIL AS (
	SELECT C06_ORDER_ID orderID
    FROM T06_ORDER
    WHERE C06_ORDER_ID NOT IN(11,12)
)
SELECT 
    orderID,
    0 AS C07_TOTAL_OF_MONEY,
    ELT(FLOOR(1 + RAND() * 4), 20, 30, 40, 50) AS DELIVERY_FEE
FROM CTE_ORDER_DETAIL;


-- 2. Tạo dữ liệu kiểm thử cho bảng T17_ORDER_STATUS_DETAIL
INSERT INTO T17_ORDER_STATUS_DETAIL(C17_ORDER_ID, C17_ORDER_STATUS_ID, C17_EMPLOYEE_ID, C17_LAST_UPDATED)
WITH CTE_

-- Với >__$$__< là tham số truyền vào

-- 3. Liệt kê toàn bộ thông tin các loại hàng
SELECT * FROM T02_ITEM_GROUP;

-- 4. Liệt kê các mặt hàng thuộc loại hàng là >__$$__<
SELECT item.* FROM T01_ITEM item
where item.C01_ITEM_GROUP_ID
IN (1);

-- 5. Liệt kê top 5 mặt hàng có giá bán cao nhất
SELECT  item.C01_ITEM_NAME,detail.C14_SALES_PRICE FROM T14_ITEM_DETAIL detail
JOIN T01_ITEM item ON detail.C14_ITEM_ID = item.C01_ITEM_ID
GROUP BY detail.C14_SALES_PRICE, item.C01_ITEM_NAME
order by detail.C14_SALES_PRICE DESC
LIMIT 5;


-- 6. Liệt kê toàn bộ đơn hàng
SELECT * FROM T06_ORDER;

-- 7. Liệt kê các đơn hàng được bán trong ngày >__$$__<
SELECT * FROM T06_ORDER WHERE date(C06_ORDER_DATE) = '2026-04-12';

-- 8. Liệt kê các đơn hàng được bán từ ngày >__$$1__< đến ngày >__$$2__<
SELECT * FROM T06_ORDER WHERE date(C06_ORDER_DATE) BETWEEN '2026-04-12' AND '2026-04-16';

-- 9. Liệt kê các đơn hàng được bán trong tháng __mm/yyyy__
SELECT * FROM T06_ORDER WHERE month(C06_ORDER_DATE) = 4 AND year(C06_ORDER_DATE) = 2026;

-- 10. Liệt kê các đơn hàng được giao tại >__$$__<
SELECT * FROM T06_ORDER WHERE T06_ORDER.C06_DELIVERY_ADDRESS = 'Địa chỉ 5';

-- 11. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi >__$$__<, làm tròn 2 chữ số thập phân

-- 12. Giảm giá >__$$__< tất cả các mặt hàng trong ngày >__dd/mm/yyyy__<

-- 13. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT C01_COLOR
FROM T01_ITEM 
GROUP BY C01_COLOR;

-- 14. Liệt kê thông tin các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày >__dd/mm/yyyy__<
-- SELECT  item.C01_ITEM_ID,item.C01_ITEM_NAME FROM T14_ITEM_DETAIL detail
-- JOIN T01_ITEM item ON detail.C14_ITEM_ID = item.C01_ITEM_ID
-- JOIN T16_ORDER_DETAIL od ON od.C16_ITEM_DETAIL_ID = detail.C14_ITEM_DETAIL_ID
-- JOIN T06_ORDER o ON od.C16_ORDER_ID = o.C06_ORDER_ID
-- WHERE o.C06_ORDER_DATE = '


-- 15. Liệt kê các mặt hàng có giá bán từ >__$$1__< đến >__$$2__<
SELECT  item.C01_ITEM_NAME, size.C04_SIZE_NAME,detail.C14_SALES_PRICE FROM T14_ITEM_DETAIL detail
JOIN T01_ITEM item ON detail.C14_ITEM_ID = item.C01_ITEM_ID
JOIN T04_SIZE size ON size.C04_SIZE_ID = detail.C14_SIZE_ID
WHERE detail.C14_SALES_PRICE BETWEEN 200 AND 400;

-- 16. Liệt kê tất cả các mặt hàng thuộc loại hàng là >__$$1__< và >__$$2__<
SELECT item.*
FROM T01_ITEM item JOIN T02_ITEM_GROUP ig ON item.C01_ITEM_GROUP_ID = ig.C02_ITEM_GROUP_ID
WHERE C02_ITEM_GROUP_ID;

-- 17. Liệt kê các đơn hàng được đặt trong ngày (>__$$1__<, >__$$2__<)
SELECT * FROM T06_ORDER WHERE date(C06_ORDER_DATE) IN ('2026-04-12', '2026-04-14');

-- 18. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT * FROM T01_ITEM
ORDER BY C01_BUY_PRICE;

-- 19. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT * FROM T01_ITEM
ORDER BY C01_BUY_PRICE DESC;

-- 20. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT  item.C01_ITEM_NAME, item.C01_BUY_PRICE,detail.C14_SALES_PRICE FROM T14_ITEM_DETAIL detail
JOIN T01_ITEM item ON detail.C14_ITEM_ID = item.C01_ITEM_ID
ORDER BY detail.C14_SALES_PRICE ASC, item.C01_BUY_PRICE DESC;

-- 21. Đếm số lượng các mặt hàng trong hệ thống
SELECT COUNT(C01_ITEM_ID)
FROM T01_ITEM;


-- 22. Số lượng 'Giày da Nam' được bán trong ngày >__$$__<

-- 23. Đếm số lượng các mặt hàng theo từng loại hàng

SELECT 
    ig.C02_ITEM_GROUP_NAME,
    COUNT(item.C01_ITEM_ID) AS Soluong
FROM T02_ITEM_GROUP ig
LEFT JOIN T01_ITEM item 
    ON ig.C02_ITEM_GROUP_ID = item.C01_ITEM_GROUP_ID
GROUP BY ig.C02_ITEM_GROUP_ID, ig.C02_ITEM_GROUP_NAME;

-- 24. Tìm mặt hàng có giá bán cao nhất trong loại hàng >__$$__<

-- 25. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
WITH MaxPricePerGroup AS (
    SELECT 
        i.C01_ITEM_GROUP_ID, 
        MAX(id.C14_SALES_PRICE) AS MAX_PRICE
    FROM T14_ITEM_DETAIL id
    JOIN T01_ITEM i 
        ON id.C14_ITEM_ID = i.C01_ITEM_ID
    GROUP BY i.C01_ITEM_GROUP_ID
)

SELECT 
    i.C01_ITEM_GROUP_ID,
    id.C14_ITEM_ID,
    id.C14_SALES_PRICE
FROM T14_ITEM_DETAIL id
JOIN T01_ITEM i 
    ON id.C14_ITEM_ID = i.C01_ITEM_ID
JOIN MaxPricePerGroup mpg 
    ON i.C01_ITEM_GROUP_ID = mpg.C01_ITEM_GROUP_ID 
   AND id.C14_SALES_PRICE = mpg.MAX_PRICE;




-- 26. Tìm tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
SELECT 
    C01_ITEM_GROUP_ID, 
    COUNT(*) AS TOTAL_ITEMS
FROM T01_ITEM
GROUP BY C01_ITEM_GROUP_ID;

-- 27. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống, điều kiện tổng số lượng >__$$__< mặt hàng

-- 28. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng

-- 29. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT ig.C02_ITEM_GROUP_NAME,AVG(detail.C14_SALES_PRICE) GiaTrungBinh
FROM T01_ITEM item INNER JOIN T14_ITEM_DETAIL detail
ON item.C01_ITEM_ID = detail.C14_ITEM_ID
INNER JOIN T02_ITEM_GROUP ig ON ig.C02_ITEM_GROUP_ID = item.C01_ITEM_GROUP_ID
GROUP BY ig.C02_ITEM_GROUP_ID, ig.C02_ITEM_GROUP_NAME;


-- 30. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
-- WITH CTE_MAX_INVENTORY AS (
-- 	SELECT 
-- )

-- 31. Liệt kê những mặt hàng có MaLoai = >__$$1__< và thuộc đơn hàng >__$$2__<

-- 32. Tìm những mặt hàng có Mã Loại = >__$$1__< và đã được bán trong ngày >__dd/mm__<

-- 33. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày >__d/m/y__<

-- 34. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE T14_ITEM_DETAIL
SET C14_SALES_PRICE = 199
WHERE C14_ITEM_ID IN (
	SELECT item.C01_ITEM_ID
    FROM T01_ITEM item INNER JOIN T02_ITEM_GROUP ig
    ON item.C01_ITEM_GROUP_ID = ig.C02_ITEM_GROUP_ID
    WHERE ig.C02_ITEM_GROUP_NAME = 'Áo'
);

-- 35. Backup data. Tạo table LoaiHang_SaoLuu(MaLoai, TenLoai), sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_SaoLuu
CREATE TABLE LoaiHang_SaoLuu AS
SELECT 
    C02_ITEM_GROUP_ID AS MaLoai, 
    C02_ITEM_GROUP_NAME AS TenLoai
FROM T02_ITEM_GROUP;

-- 36. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng >__$$1__< và >__$$2__<

-- 37. Tính tổng tiền cho đơn hàng 02, với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
SELECT 
    od.C16_ORDER_ID AS MaDonHang,
    SUM(id.C14_SALES_PRICE * od.C16_AMOUNT) AS TongTien
FROM T16_ORDER_DETAIL od
INNER JOIN T14_ITEM_DETAIL id 
    ON od.C16_ITEM_DETAIL_ID = id.C14_ITEM_DETAIL_ID
WHERE od.C16_ORDER_ID = 2
GROUP BY od.C16_ORDER_ID;


-- 38. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
-- SoDH
-- ChiTietDonHang = [TenMH:GiaBan:SoLuong]
-- TongTien

	
-- 39. Xuất thông tin hóa đơn của các đơn hàng có trong hệ thống với thông tin như sau.
-- SoDH
-- ChiTietDonHang = [TenMH:GiaBan:SoLuong]
-- TongTien

-- 40. Cập nhật thông tin tổng tiền cho bảng T07_BILL
