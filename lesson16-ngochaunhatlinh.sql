-- ======================= REFRESH DATA =======================

-- 1. Tạo dữ liệu kiểm thử cho bảng T07_BILL
INSERT INTO t07_bill
(
    C07_BILL_ID,
    C07_ORDER_ID,
    C07_TOTAL_OF_MONEY,
    C07_DELIVERY_FEE
)
SELECT
    C06_ORDER_ID,
    C06_ORDER_ID,
    0,
    0
FROM t06_order o
WHERE NOT EXISTS (
    SELECT 1
    FROM t07_bill b
    WHERE b.C07_ORDER_ID = o.C06_ORDER_ID
);

-- 2. Tạo dữ liệu kiểm thử cho bảng T17_ORDER_STATUS_DETAIL
INSERT INTO t17_order_status_detail
(
    C17_ORDER_ID,
    C17_ORDER_STATUS_ID,
    C17_EMPLOYEE_ID,
    C17_LAST_UPDATED
)
SELECT
    C06_ORDER_ID,
    1,
    C06_EMPLOYEE_ID,
    C06_ORDER_DATE
FROM t06_order o
WHERE NOT EXISTS (
    SELECT 1
    FROM t17_order_status_detail os
    WHERE os.C17_ORDER_ID = o.C06_ORDER_ID
      AND os.C17_ORDER_STATUS_ID = 1
);

-- Với >1< là tham số truyền vào

-- 3. Liệt kê toàn bộ thông tin các loại hàng
SELECT * FROM t02_item_group;

-- 4. Liệt kê các mặt hàng thuộc loại hàng là >Giày<
SET @LoaiHang = 'Giày';

SELECT DISTINCT i.*
FROM t01_item i
LEFT JOIN t03_sub_item_group s
    ON i.C01_SIG_ID = s.C03_SIG_ID
JOIN t02_item_group g
    ON g.C02_ITEM_GROUP_ID =
       COALESCE(i.C01_ITEM_GROUP_ID, s.C03_ITEM_GROUP_ID)
WHERE g.C02_ITEM_GROUP_NAME = @LoaiHang;

-- 5. Liệt kê top 5 mặt hàng có giá bán cao nhất
SELECT
    i.C01_ITEM_ID,
    i.C01_ITEM_NAME,
    MAX(d.C14_SALES_PRICE) AS GiaBan
FROM t01_item i
JOIN t14_item_detail d
    ON i.C01_ITEM_ID = d.C14_ITEM_ID
GROUP BY
    i.C01_ITEM_ID,
    i.C01_ITEM_NAME
ORDER BY GiaBan DESC
LIMIT 5;

-- 6. Liệt kê toàn bộ đơn hàng
SELECT *
FROM t06_order;

-- 7. Liệt kê các đơn hàng được bán trong ngày >18/04/2026<
SET @Ngay = '18/04/2026';

SELECT *
FROM t06_order
WHERE DATE(C06_ORDER_DATE)
      = STR_TO_DATE(@Ngay, '%d/%m/%Y');

-- 8. Liệt kê các đơn hàng được bán từ ngày >10/04/2026< đến ngày >20/04/2026<
SET @Ngay1 = '10/04/2026';
SET @Ngay2 = '20/04/2026';

SELECT *
FROM t06_order
WHERE DATE(C06_ORDER_DATE)
BETWEEN STR_TO_DATE(@Ngay1, '%d/%m/%Y')
    AND STR_TO_DATE(@Ngay2, '%d/%m/%Y');

-- 9. Liệt kê các đơn hàng được bán trong tháng __4/2026__
SET @Thang = 4;
SET @Nam = 2026;

SELECT *
FROM t06_order
WHERE MONTH(C06_ORDER_DATE) = @Thang
  AND YEAR(C06_ORDER_DATE) = @Nam;

-- 10. Liệt kê các đơn hàng được giao tại >Địa chỉ 1<
SET @DiaChi = 'Địa chỉ 1';

SELECT *
FROM t06_order
WHERE C06_DELIVERY_ADDRESS = @DiaChi;

-- 11. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi >10%<, làm tròn 2 chữ số thập phân
SET @KhuyenMai = 10;

SELECT
    i.C01_ITEM_ID,
    i.C01_ITEM_NAME,
    d.C14_ITEM_DETAIL_ID,
    d.C14_SALES_PRICE AS GiaCu,

    ROUND(
        d.C14_SALES_PRICE * (1 - @KhuyenMai / 100),
        2
    ) AS GiaSauKhuyenMai

FROM t01_item i
JOIN t14_item_detail d
    ON i.C01_ITEM_ID = d.C14_ITEM_ID;

-- 12. Giảm giá >__$$__< tất cả các mặt hàng trong ngày >__dd/mm/yyyy__<

-- 13. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT C01_COLOR
FROM t01_item;

-- 14. Liệt kê thông tin các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày >__dd/mm/yyyy__<

-- 15. Liệt kê các mặt hàng có giá bán từ >350< đến >400<
SET @Gia1 = 350;
SET @Gia2 = 400;

SELECT
    i.C01_ITEM_ID,
    i.C01_ITEM_NAME,
    d.C14_ITEM_DETAIL_ID,
    d.C14_SIZE_ID,
    d.C14_SALES_PRICE

FROM t01_item i
JOIN t14_item_detail d
    ON i.C01_ITEM_ID = d.C14_ITEM_ID

WHERE d.C14_SALES_PRICE
      BETWEEN @Gia1 AND @Gia2;

-- 16. Liệt kê tất cả các mặt hàng thuộc loại hàng là >Áo< và >Giày<
SET @Loai1 = 'Áo';
SET @Loai2 = 'Giày';

SELECT DISTINCT
    i.C01_ITEM_ID,
    i.C01_ITEM_NAME,
    g.C02_ITEM_GROUP_NAME

FROM t01_item i

LEFT JOIN t03_sub_item_group s
    ON i.C01_SIG_ID = s.C03_SIG_ID

JOIN t02_item_group g
    ON g.C02_ITEM_GROUP_ID =
       COALESCE(i.C01_ITEM_GROUP_ID, s.C03_ITEM_GROUP_ID)

WHERE g.C02_ITEM_GROUP_NAME
      IN (@Loai1, @Loai2);

-- 17. Liệt kê các đơn hàng được đặt trong ngày (>__$$1__<, >__$$2__<)

-- 18. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT
    i.C01_ITEM_ID,
    i.C01_ITEM_NAME,
    d.C14_SIZE_ID,
    d.C14_SALES_PRICE
FROM t01_item i
JOIN t14_item_detail d
    ON i.C01_ITEM_ID = d.C14_ITEM_ID

ORDER BY d.C14_SALES_PRICE ASC;

-- 19. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT *
FROM t01_item
ORDER BY C01_BUY_PRICE DESC;

-- 20. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT
    i.C01_ITEM_ID,
    i.C01_ITEM_NAME,
    i.C01_BUY_PRICE,
    d.C14_SALES_PRICE

FROM t01_item i
JOIN t14_item_detail d
    ON i.C01_ITEM_ID = d.C14_ITEM_ID

ORDER BY
    d.C14_SALES_PRICE ASC,
    i.C01_BUY_PRICE DESC;

-- 21. Đếm số lượng các mặt hàng trong hệ thống
SELECT
    COUNT(*) AS SoLuongMatHang
FROM t01_item;

-- 22. Số lượng 'Giày da Nam' được bán trong ngày >__$$__<

-- 23. Đếm số lượng các mặt hàng theo từng loại hàng

-- 24. Tìm mặt hàng có giá bán cao nhất trong loại hàng >Giày<
SET @Loai = 'Giày';

WITH BangGia AS (
    SELECT
        i.C01_ITEM_ID,
        i.C01_ITEM_NAME,

        COALESCE(
            i.C01_ITEM_GROUP_ID,
            s.C03_ITEM_GROUP_ID
        ) AS MaLoai,

        MAX(d.C14_SALES_PRICE) AS GiaBan

    FROM t01_item i

    LEFT JOIN t03_sub_item_group s
        ON i.C01_SIG_ID = s.C03_SIG_ID

    JOIN t14_item_detail d
        ON i.C01_ITEM_ID = d.C14_ITEM_ID

    GROUP BY
        i.C01_ITEM_ID,
        i.C01_ITEM_NAME,
        MaLoai
)

SELECT bg.*
FROM BangGia bg

JOIN t02_item_group g
    ON bg.MaLoai = g.C02_ITEM_GROUP_ID

WHERE g.C02_ITEM_GROUP_NAME = @Loai

AND bg.GiaBan = (
    SELECT MAX(bg2.GiaBan)
    FROM BangGia bg2
    WHERE bg2.MaLoai = bg.MaLoai
);

-- 25. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng

-- 26. Tìm tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống

-- 27. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống, điều kiện tổng số lượng >500< mặt hàng
SET @SoLuong = 500;

SELECT
    g.C02_ITEM_GROUP_ID,
    g.C02_ITEM_GROUP_NAME,
    SUM(d.C14_AMOUNT) AS TongSoLuong

FROM t01_item i

LEFT JOIN t03_sub_item_group s
    ON i.C01_SIG_ID = s.C03_SIG_ID

JOIN t02_item_group g
    ON g.C02_ITEM_GROUP_ID =
       COALESCE(i.C01_ITEM_GROUP_ID,
                s.C03_ITEM_GROUP_ID)

JOIN t14_item_detail d
    ON i.C01_ITEM_ID = d.C14_ITEM_ID

GROUP BY
    g.C02_ITEM_GROUP_ID,
    g.C02_ITEM_GROUP_NAME

HAVING SUM(d.C14_AMOUNT) > @SoLuong;
-- 28. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng

-- 29. Hiển thị giá bán trung bình của mỗi loại hàng

-- 30. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT
    g.C02_ITEM_GROUP_ID,
    g.C02_ITEM_GROUP_NAME,

    SUM(d.C14_AMOUNT)
        AS TongTonKho

FROM t01_item i

LEFT JOIN t03_sub_item_group s
    ON i.C01_SIG_ID = s.C03_SIG_ID

JOIN t02_item_group g
    ON g.C02_ITEM_GROUP_ID =
       COALESCE(i.C01_ITEM_GROUP_ID,
                s.C03_ITEM_GROUP_ID)

JOIN t14_item_detail d
    ON i.C01_ITEM_ID = d.C14_ITEM_ID

GROUP BY
    g.C02_ITEM_GROUP_ID,
    g.C02_ITEM_GROUP_NAME

ORDER BY TongTonKho DESC

LIMIT 3;
-- 31. Liệt kê những mặt hàng có MaLoai = >__$$1__< và thuộc đơn hàng >__$$2__<

-- 32. Tìm những mặt hàng có Mã Loại = >__$$1__< và đã được bán trong ngày >__dd/mm__<

-- 33. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày >__d/m/y__<

-- 34. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE t14_item_detail d

JOIN t01_item i
    ON d.C14_ITEM_ID =
       i.C01_ITEM_ID

LEFT JOIN t03_sub_item_group s
    ON i.C01_SIG_ID =
       s.C03_SIG_ID

JOIN t02_item_group g
    ON g.C02_ITEM_GROUP_ID =
       COALESCE(
           i.C01_ITEM_GROUP_ID,
           s.C03_ITEM_GROUP_ID
       )

SET d.C14_SALES_PRICE = 199

WHERE g.C02_ITEM_GROUP_NAME = 'Áo';
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
SELECT
    od.C16_ORDER_ID,

    SUM(
        d.C14_SALES_PRICE
        * od.C16_AMOUNT
    ) AS TongTien

FROM t16_order_detail od

JOIN t14_item_detail d
    ON od.C16_ITEM_DETAIL_ID =
       d.C14_ITEM_DETAIL_ID

GROUP BY od.C16_ORDER_ID;

