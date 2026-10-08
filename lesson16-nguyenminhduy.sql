DROP DATABASE IF EXISTS lesson16_company;
CREATE DATABASE lesson16_company CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE lesson16_company;
-- Phần A. Phân tích và viết các lệnh để xây dựng cơ sở dữ liệu dựa vào mô tả phía trên
CREATE TABLE phong_ban (
	ma_pb INT PRIMARY KEY,
	ten_pb VARCHAR(100) NOT NULL UNIQUE,
    ma_truong_phong INT NULL,
    ngay_nhan_chuc DATE NULL,
    CONSTRAINT ck_pb_truong_ngay CHECK (
		(ma_truong_phong IS NULL AND ngay_nhan_chuc IS NULL) OR
        (ma_truong_phong IS NOT NULL AND ngay_nhan_chuc IS NOT NULL)
		)
	) ENGINE=InnoDB;

-- Thiếu phần quan trọng: ma_truong_phong phải là UNIQUE vì quan hệ 1-1, dùng để phân biệt với FK ở quan hệ 1-N em hi -2đ
-- Chỗ CONSTRAINT ck_pb_truong_ngay tốt +1đ, nhưng thường a thấy sẽ hay xử lý ở BackEnd level, nhưng có ở DB càng tốt
    
CREATE TABLE nhan_vien (
	ma_nv INT PRIMARY KEY,
    ho_ten VARCHAR(100) NOT NULL,
	dia_chi VARCHAR(100) NOT NULL,
    luong DECIMAL(15,2) NOT NULL,
    gioi_tinh VARCHAR(100) NOT NULL,
    ngay_sinh DATE NOT NULL,
    ngay_vao_cong_ty DATE NOT NULL,
    ma_pb INT NOT NULL,
    ma_giam_sat INT NULL,
    CONSTRAINT ck_nv_luong CHECK (luong >= 0),
    CONSTRAINT ck_nv_gioi_tinh CHECK (gioi_tinh IN ('Nam', 'Nu', 'Khac')),
	CONSTRAINT ck_nv_khong_tu_giam_sat CHECK (ma_giam_sat IS NULL OR ma_giam_sat <> ma_nv),
    CONSTRAINT fk_nv_phong_ban FOREIGN KEY (ma_pb) REFERENCES phong_ban(ma_pb),
    CONSTRAINT fk_nv_giam_sat FOREIGN KEY (ma_giam_sat) REFERENCES nhan_vien(ma_nv)
    ) ENGINE=InnoDB;
    
    ALTER TABLE phong_ban
		ADD CONSTRAINT fk_pb_truong_phong
        FOREIGN KEY (ma_truong_phong) REFERENCES nhan_vien(ma_nv);
        
	CREATE TABLE du_an (
		ma_da INT PRIMARY KEY,
        ten_da VARCHAR(150) NOT NULL UNIQUE,
        ngay_bat_dau DATE NOT NULL,
        ngay_ket_thuc DATE NULL,
        tien_thu_duoc DECIMAL(18,2) NOT NULL,
        ma_quan_ly INT NOT NULL,
		CONSTRAINT ck_da_thoi_gian CHECK (ngay_ket_thuc IS NULL OR ngay_ket_thuc >= ngay_bat_dau),	
        CONSTRAINT ck_da_tien_thu CHECK (tien_thu_duoc >= 0),
        CONSTRAINT fk_da_quan_ly FOREIGN KEY (ma_quan_ly) REFERENCES nhan_vien(ma_nv)
	) ENGINE=InnoDB;
    
    CREATE TABLE tham_gia (
		ma_nv INT NOT NULL,
		ma_da INT NOT NULL,
        so_gio DECIMAL(8,2) NOT NULL DEFAULT 0,
        PRIMARY KEY (ma_nv, ma_da),
        CONSTRAINT ck_tg_so_gio CHECK (so_gio >= 0),
        CONSTRAINT fk_tg_nhan_vien FOREIGN KEY (ma_nv) REFERENCES nhan_vien(ma_nv),
        CONSTRAINT fk_tg_du_an FOREIGN KEY (ma_da) REFERENCES du_an(ma_da)
	)ENGINE=InnoDB;
    
	CREATE TABLE nhat_ky_tham_gia(
		ma_log BIGINT AUTO_INCREMENT PRIMARY KEY,
		ma_nv INT NOT NULL,
		ma_da INT NOT NULL,
		hanh_dong ENUM('THAM_GIA', 'CAP_NHAT_GIO') NOT NULL,
		thoi_diem DATETIME(6) NOT NULL,
		so_gio_cu DECIMAL(8,2) NULL,
		so_gio_moi DECIMAL(8,2) NOT NULL,
		CONSTRAINT fk_log_nhan_vien FOREIGN KEY (ma_nv) REFERENCES nhan_vien(ma_nv),
		CONSTRAINT fk_log_du_an FOREIGN KEY (ma_da) REFERENCES du_an(ma_da)
	)ENGINE=InnoDB;
    
    -- Phần C: câu 8
    DELIMITER $$
	CREATE TRIGGER trg_tham_gia_insert
	AFTER INSERT ON tham_gia
	FOR EACH ROW
	BEGIN
		INSERT INTO nhat_ky_tham_gia
			(ma_nv, ma_da, hanh_dong, thoi_diem, so_gio_cu, so_gio_moi)
		VALUES (NEW.ma_nv, NEW.ma_da, 'THAM_GIA', CURRENT_TIMESTAMP(6), NULL, NEW.so_gio);
	END$$

	CREATE TRIGGER trg_tham_gia_update
	AFTER UPDATE ON tham_gia
	FOR EACH ROW
	BEGIN
		IF NOT (OLD.so_gio <=> NEW.so_gio) THEN
			INSERT INTO nhat_ky_tham_gia
				(ma_nv, ma_da, hanh_dong, thoi_diem, so_gio_cu, so_gio_moi)
			VALUES (NEW.ma_nv, NEW.ma_da, 'CAP_NHAT_GIO', CURRENT_TIMESTAMP(6),
					OLD.so_gio, NEW.so_gio);
		END IF;
	END$$
	DELIMITER ;

-- Phần A: 50đ - 1đ(câu 1) - 10đ(english) = 39đ
-- Tốt: Em thêm các đoạn check constraint kỹ
-- Chưa tốt: Tên table, column không được đặt tiếng việt tương tự class, attribute a dặn kỹ rồi -10đ
-- Cái engine = innodb là option khi em tạo table hỗ trợ READ tốt hơn như data structure mình học vậy, nó là default của mysql e ko cần thêm
-- chỉ khi nào e muốn dùng engine khác kiểu WRITE nhiều thì đổi engine khác
    
    
-- Phần B. Viết các lệnh để tạo dữ liệu kiểm thử cho dự án
-- Yêu cầu: Ít nhất 5 dòng cho mỗi bảng dữ liệu
	INSERT INTO phong_ban (ma_pb, ten_pb) VALUES
    (1, 'Cong nghe thong tin'), (2, 'Ke toan'), (3, 'Nhan su'),
    (4, 'Kinh doanh'), (5, 'Marketing');
    INSERT INTO nhan_vien
    (ma_nv, ho_ten, dia_chi, luong, gioi_tinh, ngay_sinh, ngay_vao_cong_ty, ma_pb, ma_giam_sat)
VALUES
    (1, 'Nguyen Minh Anh', 'Ha Noi', 30000000, 'Nu', '1988-05-12', '2015-01-10', 1, NULL),
    (2, 'Tran Quoc Bao', 'Da Nang', 28000000, 'Nam', '1987-11-20', '2016-03-15', 2, NULL),
    (3, 'Le Thu Ha', 'Ha Noi', 27000000, 'Nu', '1990-02-01', '2018-08-01', 3, NULL),
    (4, 'Pham Van Long', 'TP Ho Chi Minh', 29000000, 'Nam', '1986-07-04', '2014-06-01', 4, NULL),
    (5, 'Do Ngoc Mai', 'Hai Phong', 26000000, 'Nu', '1991-09-09', '2019-11-20', 5, NULL);

INSERT INTO nhan_vien
    (ma_nv, ho_ten, dia_chi, luong, gioi_tinh, ngay_sinh, ngay_vao_cong_ty, ma_pb, ma_giam_sat)
VALUES
    (6, 'Bui Duc Huy', 'Ha Noi', 32000000, 'Nam', '1995-01-12', '2020-01-10', 1, 1),
    (7, 'Hoang Thi Lan', 'Da Nang', 22000000, 'Nu', '1997-04-11', '2022-05-15', 1, 1),
    (8, 'Vo Minh Khoa', 'Hue', 25000000, 'Nam', '1993-12-05', '2019-03-20', 2, 2),
    (9, 'Nguyen Gia Phuc', 'Can Tho', 31000000, 'Nam', '1996-08-19', '2021-07-01', 4, 4),
    (10, 'Trinh Bao Ngoc', 'Ha Noi', 21000000, 'Nu', '1998-06-23', '2024-09-10', 5, 5);

UPDATE phong_ban SET ma_truong_phong = 1, ngay_nhan_chuc = '2018-01-01' WHERE ma_pb = 1;
UPDATE phong_ban SET ma_truong_phong = 2, ngay_nhan_chuc = '2019-01-01' WHERE ma_pb = 2;
UPDATE phong_ban SET ma_truong_phong = 3, ngay_nhan_chuc = '2020-01-01' WHERE ma_pb = 3;
UPDATE phong_ban SET ma_truong_phong = 4, ngay_nhan_chuc = '2017-01-01' WHERE ma_pb = 4;
UPDATE phong_ban SET ma_truong_phong = 5, ngay_nhan_chuc = '2021-01-01' WHERE ma_pb = 5;

INSERT INTO du_an
    (ma_da, ten_da, ngay_bat_dau, ngay_ket_thuc, tien_thu_duoc, ma_quan_ly)
VALUES
    (101, 'He thong ban hang', '2024-10-01', '2025-06-30', 850000000, 1),
    (102, 'Ung dung di dong', '2025-02-01', '2025-12-31', 1200000000, 1),
    (103, 'Quan ly kho', '2025-08-01', '2026-05-31', 620000000, 2),
    (104, 'Chien dich thuong hieu', '2026-01-15', NULL, 400000000, 5),
    (105, 'Phan tich khach hang', '2026-03-01', NULL, 950000000, 4);
INSERT INTO tham_gia (ma_nv, ma_da, so_gio) VALUES
    (1, 101, 120), (6, 101, 180), (7, 101, 90),
    (1, 102, 110), (6, 102, 160), (9, 102, 75),
    (2, 103, 130), (8, 103, 200), (3, 103, 65),
    (5, 104, 140), (10, 104, 170),
    (4, 105, 155), (9, 105, 185), (7, 105, 60);
UPDATE tham_gia SET so_gio = 190 WHERE ma_nv = 6 AND ma_da = 101;
UPDATE tham_gia SET so_gio = 205 WHERE ma_nv = 8 AND ma_da = 103;
SET @nam_can_tim = 2025;
SET @nguong_trieu = 700;
SET @nguong_gio = 200;
SET @nguong_nhan_vien = 2;
SET @nguong_nam = 5;

-- Phần B: 5đ
    

-- Phần C. Thực hiện truy vấn
-- 1. Liệt kê các dự án diễn ra trong năm *?* có số tiền thu được trên *?* triệu VND
	SELECT ma_da, ten_da, ngay_bat_dau, ngay_ket_thuc, tien_thu_duoc
    FROM du_an
    WHERE ngay_bat_dau < MAKEDATE(@nam_can_tim +1, 1)
		AND (ngay_ket_thuc IS NULL OR ngay_ket_thuc >= MAKEDATE(@nam_can_tim, 1))
        AND tien_thu_duoc > @nguong_trieu * 1000000
	ORDER BY ma_da;

-- Chính xác
-- Nếu đã lỡ dùng >= thì e có thể đổi luôn chỗ này xíu: ngay_bat_dau <= MAKEDATE(@nam_can_tim, 1)
    
-- 2. Liệt kê các nhân viên đã tham gia hơn ?*? giờ trong các dự án, hiển thị chi tiết số giờ trong mỗi dự án mà nhân viên tham gia
	SELECT nv.ma_nv, nv.ho_ten, da.ma_da, da.ten_da,
			tg.so_gio AS so_gio_du_an, tong.tong_so_gio
	FROM nhan_vien AS nv
    JOIN (SELECT ma_nv, SUM(so_gio) AS tong_so_gio
			FROM tham_gia
            GROUP BY ma_nv
            HAVING SUM(so_gio) >  @nguong_gio) AS tong ON tong.ma_nv = nv.ma_nv
	JOIN tham_gia AS tg ON tg.ma_nv = nv.ma_nv
    JOIN du_an AS da ON da.ma_da = tg.ma_da
    ORDER BY nv.ma_nv, da.ma_da;

-- Chính xác

-- 3. Liệt kê các nhân viên có mức lương >= mức lương của người giám sát/quản lý trực tiếp nhân viên đó
	SELECT nv.ma_nv, nv.ho_ten, nv.luong,
		gs.ma_nv AS ma_giam_sat, gs.ho_ten AS ten_giam_sat, gs.luong AS luong_giam_sat
	FROM nhan_vien AS nv
    JOIN nhan_vien AS gs ON gs.ma_nv = nv.ma_giam_sat
    WHERE nv.luong >= gs.luong
    ORDER BY nv.ma_nv;
    
-- Chính xác

-- 4. Liệt kê các phòng ban có số lượng nhân viên lớn hơn *?*
	SELECT pb.ma_pb, pb.ten_pb, COUNT(nv.ma_nv) AS so_nhan_vien
    FROM phong_ban AS pb
    LEFT JOIN nhan_vien AS nv ON nv.ma_pb = pb.ma_pb
    GROUP BY pb.ma_pb, pb.ten_pb
    HAVING COUNT(nv.ma_nv) > @nguong_nhan_vien
    ORDER BY pb.ma_pb;
    
-- Chính xác
-- Chỗ COUNT em có thể dùng COUNT(*)
    
-- 5. Liệt kê các nhân viên đã làm việc cho công ty hơn ?*? năm
	SELECT ma_nv, ho_ten, ngay_vao_cong_ty,
		timestampdiff(YEAR, ngay_vao_cong_ty, CURDATE()) AS so_nam_lam_viec
	FROM  nhan_vien
    WHERE timestampdiff(YEAR, ngay_vao_cong_ty, CURDATE()) > @nguong_nam
    ORDER BY ma_nv;
    
-- Chính xác
    
-- 6. Liệt kê các nhân viên vừa là trưởng phòng ban, và là quản lý dự án
	SELECT DISTINCT nv.ma_nv, nv.ho_ten, pb.ma_pb, pb.ten_pb
    FROM nhan_vien AS nv
    JOIN phong_ban AS pb ON pb.ma_truong_phong = nv.ma_nv
    ORDER BY nv.ma_nv;
    
-- Thiếu: Chỉ mới kiểm tra NhanVien là TruongPhongBan, thiếu QuanLyDuAn
    
-- 7. Liệt kê các nhân viên quản lý nhiều hơn 1 dự án
	SELECT nv.ma_nv, nv.ho_ten, COUNT(da.ma_da) AS so_du_an_quan_ly
    FROM nhan_vien AS nv
    JOIN du_an AS da ON da.ma_quan_ly = nv.ma_nv
    GROUP BY nv.ma_nv, nv.ho_ten
    HAVING COUNT(da.ma_da) > 1
    ORDER BY so_du_an_quan_ly DESC, nv.ma_nv;
    
-- Chính xác
-- Tương tự em có thể dùng COUNT(*)

-- 8. Mỗi khi nhân viên tham gia vào dự án chúng ta cần lưu lại thông tin hay còn được gọi là log để
-- biết nhân viên đó tham gia vào dự án vào thời gian nào
-- Mỗi khi nhân viên cập nhật số giờ tham gia dự án, ta cần lưu lại thông tin thời gian cập nhật khi
-- nào, số giờ tham gia cũ, số giờ tham gia mới
-- Công việc được thực hiện tự động khi dự dữ liệu được thêm, cập nhật

-- Phần C: 45đ

-- link video: https://youtu.be/nESim2ZurDI
