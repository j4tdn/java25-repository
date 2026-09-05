-- ======================= REFRESH DATA =======================

-- 1. Tạo dữ liệu kiểm thử cho bảng T07_BILL

-- 2. Tạo dữ liệu kiểm thử cho bảng T17_ORDER_STATUS_DETAIL

-- Với >__$$__< là tham số truyền vào

-- 3. Liệt kê toàn bộ thông tin các loại hàng
SELECT * FROM t02_item_group;

-- 4. Liệt kê các mặt hàng thuộc loại hàng là >__$$__<

-- 5. Liệt kê top 5 mặt hàng có giá bán cao nhất

-- 6. Liệt kê toàn bộ đơn hàng

-- 7. Liệt kê các đơn hàng được bán trong ngày >__$$__<

-- 8. Liệt kê các đơn hàng được bán từ ngày >__$$1__< đến ngày >__$$2__<

-- 9. Liệt kê các đơn hàng được bán trong tháng __mm/yyyy__

-- 10. Liệt kê các đơn hàng được giao tại >__$$__<

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

