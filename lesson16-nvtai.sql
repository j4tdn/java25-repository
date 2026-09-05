-- ======================= REFRESH DATA =======================

-- 1. Tạo dữ liệu kiểm thử cho bảng T07_BILL
-- 1. Tạo dữ liệu kiểm thử cho bảng T07_BILL
INSERT INTO T07_BILL (
    C07_ORDER_ID, 
    C07_DELIVERY_FEE, 
    C07_TOTAL_OF_MONEY
)
SELECT 
    C06_ORDER_ID,
    ELT(FLOOR(1 + RAND() * 4), 20, 30, 40, 50) AS C07_DELIVERY_FEE,
    0 AS C07_TOTAL_OF_MONEY
FROM T06_ORDER
WHERE C06_ORDER_ID NOT IN (11, 12);

-- 2. Tạo dữ liệu kiểm thử cho bảng T17_ORDER_STATUS_DETAIL

-- Với >__$$__< là tham số truyền vào
-- 2. Tạo dữ liệu kiểm thử cho bảng T17_ORDER_STATUS_DETAIL

INSERT INTO T17_ORDER_STATUS_DETAIL (
    C17_ORDER_ID, 
    C17_ORDER_STATUS_ID, 
    C17_EMPLOYEE_ID, 
    C17_LAST_UPDATED
)
-- Nhóm 1: Đơn 1 đến 5 (Giao thành công: 1 -> 5)
SELECT 
    O.C06_ORDER_ID,
    S.status_id AS C17_ORDER_STATUS_ID,
    1 AS C17_EMPLOYEE_ID,
    TIMESTAMP('2026-04-15 08:10:20') - INTERVAL (5 - S.status_id) DAY AS C17_LAST_UPDATED
FROM T06_ORDER O
CROSS JOIN (
    SELECT 1 AS status_id UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5
) S
WHERE O.C06_ORDER_ID BETWEEN 1 AND 5

UNION ALL

-- Nhóm 2: Đơn 6 đến 8 (Đóng gói thành công: 1 -> 3)
SELECT 
    O.C06_ORDER_ID,
    S.status_id,
    2 AS C17_EMPLOYEE_ID,
    TIMESTAMP('2026-04-15 08:10:20') - INTERVAL (3 - S.status_id) DAY
FROM T06_ORDER O
CROSS JOIN (
    SELECT 1 AS status_id UNION ALL SELECT 2 UNION ALL SELECT 3
) S
WHERE O.C06_ORDER_ID BETWEEN 6 AND 8

UNION ALL

-- Nhóm 3: Đơn 9 và 10 (Đang giao hàng: 1 -> 4)
SELECT 
    O.C06_ORDER_ID,
    S.status_id,
    3 AS C17_EMPLOYEE_ID,
    TIMESTAMP('2026-04-15 08:10:20') - INTERVAL (4 - S.status_id) DAY
FROM T06_ORDER O
CROSS JOIN (
    SELECT 1 AS status_id UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4
) S
WHERE O.C06_ORDER_ID BETWEEN 9 AND 10

UNION ALL

-- Nhóm 4: Đơn 11 và 12 (Hủy đơn hàng: Trạng thái 7)
SELECT 
    C06_ORDER_ID,
    7 AS C17_ORDER_STATUS_ID,
    4 AS C17_EMPLOYEE_ID,
    TIMESTAMP('2026-04-15 08:10:20')
FROM T06_ORDER
WHERE C06_ORDER_ID IN (11, 12)

UNION ALL

-- Nhóm 5: Đơn 13 (Giao hàng thất bại: 1, 2, 3, 4, 6)
SELECT 
    O.C06_ORDER_ID,
    S.status_id,
    5 AS C17_EMPLOYEE_ID,
    TIMESTAMP('2026-04-15 08:10:20') - INTERVAL (6 - S.status_id) DAY
FROM T06_ORDER O
CROSS JOIN (
    SELECT 1 AS status_id UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 6
) S
WHERE O.C06_ORDER_ID = 13;

-- 3. Liệt kê toàn bộ thông tin các loại hàng
-- 3. Liệt kê toàn bộ thông tin các loại hàng
SELECT 
    C02_ITEM_GROUP_ID,
    C02_ITEM_GROUP_NAME,
    C02_STATUS
FROM T02_ITEM_GROUP;

-- 4. Liệt kê các mặt hàng thuộc loại hàng là >__$$__<
-- Khai báo tên loại hàng cần lọc
SET @item_group_name = 'Túi Xách'; 
SELECT 
    IG.C02_ITEM_GROUP_NAME AS TEN_LOAI_HANG,
    SIG.C03_SIG_NAME AS TEN_NHOM_CON,
    I.C01_ITEM_ID,
    I.C01_ITEM_NAME AS TEN_MAT_HANG,
    I.C01_COLOR,
    I.C01_MATERIAL,
    ID.C14_ITEM_DETAIL_ID,
    ID.C14_SALES_PRICE,
    ID.C14_AMOUNT
FROM T02_ITEM_GROUP IG
JOIN T03_SUB_ITEM_GROUP SIG 
    ON IG.C02_ITEM_GROUP_ID = SIG.C03_ITEM_GROUP_ID
JOIN T01_ITEM I 
    ON SIG.C03_SIG_ID = I.C01_SIG_ID
LEFT JOIN T14_ITEM_DETAIL ID 
    ON I.C01_ITEM_ID = ID.C14_ITEM_ID
WHERE IG.C02_ITEM_GROUP_NAME = @item_group_name;
-- 5. Liệt kê top 5 mặt hàng có giá bán cao nhất

SELECT 
    I.C01_ITEM_ID,
    I.C01_ITEM_NAME,
    S.C04_SIZE_NAME,
    ID.C14_SALES_PRICE,
    ID.C14_AMOUNT
FROM T14_ITEM_DETAIL ID
JOIN T01_ITEM I ON ID.C14_ITEM_ID = I.C01_ITEM_ID
JOIN T04_SIZE S ON ID.C14_SIZE_ID = S.C04_SIZE_ID
ORDER BY ID.C14_SALES_PRICE DESC
LIMIT 5;
-- 6. Liệt kê toàn bộ đơn hàng

SELECT 
    O.C06_ORDER_ID,
    O.C06_ORDER_DATE,
    O.C06_EXPECTED_DELIVERY_DATE,
    C.C08_CUSTOMER_NAME,
    C.C08_CUSTOMER_PHONE,
    O.C06_DELIVERY_ADDRESS,
    PM.C90_PAYMENT_METHOD_NAME,
    E.C09_EMPLOYEE_NAME,
    B.C07_TOTAL_OF_MONEY,
    B.C07_DELIVERY_FEE
FROM T06_ORDER O
LEFT JOIN T08_CUSTOMER C ON O.C06_CUSTOMER_ID = C.C08_CUSTOMER_ID
LEFT JOIN T09_EMPLOYEE E ON O.C06_EMPLOYEE_ID = E.C09_EMPLOYEE_ID
LEFT JOIN T90_PAYMENT_METHOD PM ON O.C06_PAYMENT_METHOD_ID = PM.C90_PAYMENT_METHOD_ID
LEFT JOIN T07_BILL B ON O.C06_ORDER_ID = B.C07_ORDER_ID
ORDER BY O.C06_ORDER_DATE DESC;
-- 7. Liệt kê các đơn hàng được bán trong ngày >__$$__<

SET @target_date = '2026-04-10'; 

SELECT 
    O.C06_ORDER_ID,
    O.C06_ORDER_DATE,
    C.C08_CUSTOMER_NAME,
    C.C08_CUSTOMER_PHONE,
    O.C06_DELIVERY_ADDRESS,
    PM.C90_PAYMENT_METHOD_NAME,
    E.C09_EMPLOYEE_NAME,
    B.C07_TOTAL_OF_MONEY
FROM T06_ORDER O
LEFT JOIN T08_CUSTOMER C ON O.C06_CUSTOMER_ID = C.C08_CUSTOMER_ID
LEFT JOIN T09_EMPLOYEE E ON O.C06_EMPLOYEE_ID = E.C09_EMPLOYEE_ID
LEFT JOIN T90_PAYMENT_METHOD PM ON O.C06_PAYMENT_METHOD_ID = PM.C90_PAYMENT_METHOD_ID
LEFT JOIN T07_BILL B ON O.C06_ORDER_ID = B.C07_ORDER_ID
WHERE DATE(O.C06_ORDER_DATE) = @target_date
ORDER BY O.C06_ORDER_DATE DESC;
-- 8. Liệt kê các đơn hàng được bán từ ngày >__$$1__< đến ngày >__$$2__<
-- Khai báo khoảng thời gian cần lọc (Định dạng: YYYY-MM-DD)
SET @start_date = '2026-04-14';
SET @end_date   = '2026-04-18';
SELECT 
    O.C06_ORDER_ID,
    O.C06_ORDER_DATE,
    C.C08_CUSTOMER_NAME,
    C.C08_CUSTOMER_PHONE,
    O.C06_DELIVERY_ADDRESS,
    PM.C90_PAYMENT_METHOD_NAME,
    E.C09_EMPLOYEE_NAME,
    B.C07_TOTAL_OF_MONEY
FROM T06_ORDER O
LEFT JOIN T08_CUSTOMER C ON O.C06_CUSTOMER_ID = C.C08_CUSTOMER_ID
LEFT JOIN T09_EMPLOYEE E ON O.C06_EMPLOYEE_ID = E.C09_EMPLOYEE_ID
LEFT JOIN T90_PAYMENT_METHOD PM ON O.C06_PAYMENT_METHOD_ID = PM.C90_PAYMENT_METHOD_ID
LEFT JOIN T07_BILL B ON O.C06_ORDER_ID = B.C07_ORDER_ID
WHERE DATE(O.C06_ORDER_DATE) BETWEEN @start_date AND @end_date
ORDER BY O.C06_ORDER_DATE ASC;
-- 9. Liệt kê các đơn hàng được bán trong tháng __mm/yyyy__
SET @target_month = 04;
SET @target_year  = 2026;

-- 9. Liệt kê các đơn hàng được bán trong tháng 10/2026
SELECT 
    O.C06_ORDER_ID,
    O.C06_ORDER_DATE,
    C.C08_CUSTOMER_NAME,
    C.C08_CUSTOMER_PHONE,
    O.C06_DELIVERY_ADDRESS,
    PM.C90_PAYMENT_METHOD_NAME,
    E.C09_EMPLOYEE_NAME,
    B.C07_TOTAL_OF_MONEY
FROM T06_ORDER O
LEFT JOIN T08_CUSTOMER C ON O.C06_CUSTOMER_ID = C.C08_CUSTOMER_ID
LEFT JOIN T09_EMPLOYEE E ON O.C06_EMPLOYEE_ID = E.C09_EMPLOYEE_ID
LEFT JOIN T90_PAYMENT_METHOD PM ON O.C06_PAYMENT_METHOD_ID = PM.C90_PAYMENT_METHOD_ID
LEFT JOIN T07_BILL B ON O.C06_ORDER_ID = B.C07_ORDER_ID
WHERE MONTH(O.C06_ORDER_DATE) = @target_month 
  AND YEAR(O.C06_ORDER_DATE) = @target_year
ORDER BY O.C06_ORDER_DATE ASC;
-- 10. Liệt kê các đơn hàng được giao tại >__$$__<
-- Khai báo địa chỉ/khu vực cần tìm (Ví dụ: 'Đà Nẵng', 'Quận 1', 'Hà Nội',...)
SET @delivery_address = 'Địa chỉ 10';

-- 10. Liệt kê các đơn hàng được giao tại địa chỉ/khu vực chỉ định
SELECT 
    O.C06_ORDER_ID,
    O.C06_ORDER_DATE,
    O.C06_DELIVERY_ADDRESS,
    C.C08_CUSTOMER_NAME,
    C.C08_CUSTOMER_PHONE,
    PM.C90_PAYMENT_METHOD_NAME,
    E.C09_EMPLOYEE_NAME,
    IFNULL(B.C07_TOTAL_OF_MONEY, 0) AS C07_TOTAL_OF_MONEY
FROM T06_ORDER O
LEFT JOIN T08_CUSTOMER C ON O.C06_CUSTOMER_ID = C.C08_CUSTOMER_ID
LEFT JOIN T09_EMPLOYEE E ON O.C06_EMPLOYEE_ID = E.C09_EMPLOYEE_ID
LEFT JOIN T90_PAYMENT_METHOD PM ON O.C06_PAYMENT_METHOD_ID = PM.C90_PAYMENT_METHOD_ID
LEFT JOIN T07_BILL B ON O.C06_ORDER_ID = B.C07_ORDER_ID
WHERE O.C06_DELIVERY_ADDRESS LIKE CONCAT('%', @delivery_address, '%')
ORDER BY O.C06_ORDER_DATE DESC;
-- 11. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi >__$$__<, làm tròn 2 chữ số thập phân
-- hai báo tỉ lệ khuyến mãi (Ví dụ: 10% = 0.1, 15% = 0.15, 20% = 0.2)
SET @discount_percent = 10; 
SELECT 
    I.C01_ITEM_ID,
    I.C01_ITEM_NAME AS TEN_MAT_HANG,
    S.C04_SIZE_NAME AS KICH_THUOC,
    ID.C14_SALES_PRICE AS GIA_GOC,
    CONCAT(@discount_percent, '%') AS PHAN_TRAM_KHUYEN_MAI,
    ROUND(ID.C14_SALES_PRICE * (1 - @discount_percent / 100), 2) AS GIA_SAU_KHUYEN_MAI
FROM T14_ITEM_DETAIL ID
JOIN T01_ITEM I ON ID.C14_ITEM_ID = I.C01_ITEM_ID
JOIN T04_SIZE S ON ID.C14_SIZE_ID = S.C04_SIZE_ID
ORDER BY I.C01_ITEM_ID ASC;
-- 12. Giảm giá >__$$__< tất cả các mặt hàng trong ngày >__dd/mm/yyyy__<

SET @discount_percent = 15;       
SET @promotion_date   = '2026-09-05'; 


UPDATE T14_ITEM_DETAIL
SET C14_SALES_PRICE = ROUND(C14_SALES_PRICE * (1 - @discount_percent / 100), 2);

SELECT 
    I.C01_ITEM_ID,
    I.C01_ITEM_NAME AS TEN_MAT_HANG,
    S.C04_SIZE_NAME AS KICH_THUOC,
    ID.C14_SALES_PRICE AS GIA_SAU_GIAM,
    @promotion_date AS NGAY_AP_DUNG
FROM T14_ITEM_DETAIL ID
JOIN T01_ITEM I ON ID.C14_ITEM_ID = I.C01_ITEM_ID
JOIN T04_SIZE S ON ID.C14_SIZE_ID = S.C04_SIZE_ID;
-- 13. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
-- 13. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng (không trùng lặp)
SELECT DISTINCT 
    C01_COLOR AS MAU_SAC
FROM T01_ITEM
WHERE C01_COLOR IS NOT NULL AND C01_COLOR != ''
ORDER BY C01_COLOR ASC;
-- 14. Liệt kê thông tin các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày >__dd/mm/yyyy__<
-- Khai báo ngày cần lọc (Định dạng: YYYY-MM-DD)
SET @target_date = '2026-04-18';

SELECT DISTINCT
    I.C01_ITEM_ID AS MaMH,
    I.C01_ITEM_NAME AS TenMH,
    O.C06_ORDER_DATE AS ThoiGianDatHang
FROM T06_ORDER O
JOIN T16_ORDER_DETAIL OD 
    ON O.C06_ORDER_ID = OD.C16_ORDER_ID
JOIN T14_ITEM_DETAIL ID 
    ON OD.C16_ITEM_DETAIL_ID = ID.C14_ITEM_DETAIL_ID
JOIN T01_ITEM I 
    ON ID.C14_ITEM_ID = I.C01_ITEM_ID
WHERE DATE(O.C06_ORDER_DATE) = @target_date
ORDER BY O.C06_ORDER_DATE ASC;
-- 15. Liệt kê các mặt hàng có giá bán từ >__$$1__< đến >__$$2__<
-- Khai báo khoảng giá cần lọc (Ví dụ: từ 100.000 đến 500.000)
SET @min_price = 125;
SET @max_price = 280;


SELECT DISTINCT
    I.C01_ITEM_ID AS MaMH,
    I.C01_ITEM_NAME AS TenMH,
    S.C04_SIZE_NAME AS KichThuoc,
    ID.C14_SALES_PRICE AS GiaBan
FROM T14_ITEM_DETAIL ID
JOIN T01_ITEM I ON ID.C14_ITEM_ID = I.C01_ITEM_ID
JOIN T04_SIZE S ON ID.C14_SIZE_ID = S.C04_SIZE_ID
WHERE ID.C14_SALES_PRICE BETWEEN @min_price AND @max_price
ORDER BY ID.C14_SALES_PRICE ASC;
-- 16. Liệt kê tất cả các mặt hàng thuộc loại hàng là >__$$1__< và >__$$2__<

-- 17. Liệt kê các đơn hàng được đặt trong ngày (>__$$1__<, >__$$2__<)

-- 18. Sắp xếp các mặt hàng với giá bán tăng dần

-- 19. Sắp xếp các mặt hàng với giá mua giảm dần

-- 20. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần

-- 21. Đếm số lượng các mặt hàng trong hệ thống

-- 22. Số lượng 'Giày da Nam' được bán trong ngày >__$$__<

-- 23. Đếm số lượng các mặt hàng theo từng loại hàng

-- 24. Tìm mặt hàng có giá bán cao nhất trong loại hàng >__$$__<

-- 25. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng

-- 26. Tìm tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống

-- 27. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống, điều kiện tổng số lượng >__$$__< mặt hàng

-- 28. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng

-- 29. Hiển thị giá bán trung bình của mỗi loại hàng

-- 30. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại

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

