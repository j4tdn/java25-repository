
-- LESSON 16 - EXAM
-- ĐỀ BÀI: XÂY DỰNG CƠ SỞ DỮ LIỆU QUẢN LÝ CÔNG TY

-- Xây dựng cơ sở dữ liệu quản lý công ty để theo dõi các thông tin
-- liên quan đến nhân viên, phòng ban và dự án, chi tiết như sau:

-- Công ty được tổ chức thành các phòng ban chức năng.
-- Mỗi phòng ban có một tên duy nhất, một mã số duy nhất và các nhân viên,
-- trong đó có một nhân viên là người quản lý phòng ban đó.

-- Việc nhân viên quản lý phòng ban được ghi lại tại thời điểm nhân viên
-- đó bắt đầu quản lý và được gọi là trưởng phòng.
-- Ta ghi nhận lại ngày nhận chức của trưởng phòng.

-- Công ty có nhiều dự án, mỗi dự án có một tên duy nhất, một mã số duy nhất,
-- ngày bắt đầu, ngày kết thúc (hoàn thành dự án), số tiền thu được
-- (đơn vị VNĐ) từ dự án đó.

-- Dự án được thực hiện bởi một hoặc nhiều nhân viên,
-- có một nhân viên duy nhất làm quản lý dự án.

-- Với mỗi nhân viên, lưu giữ các thông tin bao gồm:
-- họ tên, mã số duy nhất, địa chỉ, lương, giới tính,
-- ngày sinh, ngày vào công ty.

-- Một nhân viên chỉ làm việc cho một phòng ban nhưng có thể
-- làm việc cho nhiều dự án.

-- Lưu giữ số giờ làm việc của mỗi nhân viên trên dự án mà nhân viên tham gia.

-- Mỗi nhân viên có thể có một người quản lý giám sát trực tiếp,
-- người đó cũng là một nhân viên.
-- Nhân viên và người quản lý/giám sát của nhân viên có thể tham gia
-- cùng hoặc khác dự án.

-- PHẦN A. PHÂN TÍCH VÀ XÂY DỰNG CƠ SỞ DỮ LIỆU

-- Phân tích và viết các lệnh để xây dựng cơ sở dữ liệu
-- dựa vào mô tả phía trên.

-- 1, Phân tích
-- PHONGBAN (phòng ban)
-- - MaPB : mã phòng ban (PK)
-- - TenPB : tên phòng ban (UNIQUE)
-- - MaTruongPhong : mã NV đang là trưởng phòng (FK -> NHANVIEN)
-- - NgayNhanChuc : Ngày NV đó bắt đầu làm trưởng phòng

-- NHANVIEN (nhân viên)
-- - MaNV : mã nhân viên (PK)
-- - HoTen, Dia chi, Luong, GioiTinh, NgaySinh, NgayVaoLam
-- - MaPB : phòng ban đang làm việc (FK -> PHONGBAN)
-- - MaNVQuanLy : mã người quản lý (FK -> NHANVIEN)

-- DUAN (dự án)
-- - MaDA : mã dự án (PK)
-- - TenDA : tên dự án  (UNIQUE)
-- - NgayBatDau, NgayKetThuc, SoTienThu
-- - MaNVQuanLy : nhân viên quản lý dự án (FK -> NHANVIEN)

-- PHANCONG
-- - MaNV, MADA : PK,FK
-- - SoGio : số giờ nhân viên đó đã làm

-- 2, các lệnh

CREATE DATABASE QuanLyCongTy;
USE QuanLyCongTy;

CREATE TABLE PHONGBAN (
	MaPB VARCHAR(10) NOT NULL,
    TenPB NVARCHAR(100) NOT NULL,
    MaTruongPhong VARCHAR(10) NULL,
    NgayNhanChuc DATE NULL,
    constraint PK_PHONGBAN primary key(MaPB),
    constraint UQ_PHONGBAN_Ten unique (TenPB)
);

create table NHANVIEN (
    MaNV varchar(10) not null,
    HoTen nvarchar(100) not null,
    DiaChi nvarchar(200) null,
    Luong decimal(18,0) not null,
    GioiTinh nvarchar(5) null,
    NgaySinh date null,
    NgayVaoLam date not null,
    MaPB varchar(10) not null,
    MaNVQuanLy varchar(10) null,
    constraint PK_NHANVIEN primary key (MaNV),
    constraint CK_NHANVIEN_Luong check (Luong >= 0),
    constraint CK_NHANVIEN_GT check (GioiTinh in (n'Nam', n'Nữ')),
    constraint FK_NHANVIEN_PHONGBAN foreign key (MaPB) references PHONGBAN(MaPB),
    constraint FK_NHANVIEN_QUANLY foreign key (MaNVQuanLy) references NHANVIEN(MaNV)
);
alter table PHONGBAN
    add constraint FK_PHONGBAN_TRUONGPHONG foreign key (MaTruongPhong)
        references NHANVIEN(MaNV);-- 

create table DUAN (
    MaDA varchar(10) not null,
    TenDA nvarchar(100) not null,
    NgayBatDau date not null,
    NgayKetThuc date null,
    SoTienThu decimal(18,0) not null,
    MaNVQuanLy varchar(10) not null,
    constraint PK_DUAN primary key (MaDA),
    constraint UQ_DUAN_Ten unique (TenDA),
    constraint CK_DUAN_Ngay check (NgayKetThuc is null or NgayKetThuc >= NgayBatDau),
    constraint CK_DUAN_SoTien check (SoTienThu >= 0),
    constraint FK_DUAN_QUANLY foreign key (MaNVQuanLy) references NHANVIEN(MaNV)
);

create table PHANCONG (
    MaNV varchar(10) not null,
    MaDA varchar(10) not null,
    SoGio decimal(8,1) not null default 0,
    constraint PK_PHANCONG primary key (MaNV, MaDA),
    constraint CK_PHANCONG_SoGio check (SoGio >= 0),
    constraint FK_PHANCONG_NHANVIEN foreign key (MaNV) references NHANVIEN(MaNV),
    constraint FK_PHANCONG_DUAN foreign key (MaDA) references DUAN(MaDA)
);

-- PHẦN B. TẠO DỮ LIỆU KIỂM THỬ

-- Viết các lệnh để tạo dữ liệu kiểm thử cho dự án.
-- Yêu cầu: Ít nhất 5 dòng cho mỗi bảng dữ liệu.

insert into PHONGBAN (MaPB, TenPB, MaTruongPhong, NgayNhanChuc) values
('PB01', n'Phòng Kỹ Thuật',   null, null),
('PB02', n'Phòng Kinh Doanh', null, null),
('PB03', n'Phòng Nhân Sự',    null, null),
('PB04', n'Phòng Kế Toán',    null, null),
('PB05', n'Phòng Marketing',  null, null);

insert into NHANVIEN (MaNV, HoTen, DiaChi, Luong, GioiTinh, NgaySinh, NgayVaoLam, MaPB, MaNVQuanLy) values
('NV01', n'Nguyễn Văn An',  n'12 Trần Phú, Đà Nẵng',      30000000, n'Nam', '1980-05-12', '2015-01-10', 'PB01', null),
('NV02', n'Trần Thị Bình',  n'45 Lê Duẩn, Đà Nẵng',       20000000, n'Nữ',  '1990-08-20', '2016-03-15', 'PB01', 'NV01'),
('NV03', n'Lê Văn Cường',   n'8 Nguyễn Chí Thanh, Huế',   32000000, n'Nam', '1985-11-02', '2010-05-20', 'PB01', 'NV01'),
('NV04', n'Phạm Thị Dung',  n'21 Hùng Vương, Đà Nẵng',    28000000, n'Nữ',  '1982-02-14', '2014-07-01', 'PB02', null),
('NV05', n'Hoàng Văn Em',   n'99 Bạch Đằng, Đà Nẵng',     29000000, n'Nam', '1983-09-09', '2012-02-10', 'PB02', 'NV04'),
('NV06', n'Vũ Thị Phương',  n'5 Điện Biên Phủ, Huế',      25000000, n'Nữ',  '1988-04-25', '2017-09-01', 'PB03', null),
('NV07', n'Đặng Văn Giang', n'70 Nguyễn Văn Linh, ĐN',    16000000, n'Nam', '1995-06-30', '2019-11-11', 'PB03', 'NV06'),
('NV08', n'Bùi Thị Hoa',    n'18 Phan Châu Trinh, ĐN',    27000000, n'Nữ',  '1984-01-18', '2013-04-04', 'PB04', null),
('NV09', n'Ngô Văn Ích',    n'33 Ông Ích Khiêm, ĐN',      15000000, n'Nam', '1996-03-03', '2020-06-06', 'PB04', 'NV08'),
('NV10', n'Đỗ Thị Kim',     n'60 Nguyễn Tri Phương, ĐN',  26000000, n'Nữ',  '1987-12-12', '2018-08-08', 'PB05', null),
('NV11', n'Lý Văn Long',    n'14 Trưng Nữ Vương, ĐN',     17000000, n'Nam', '1993-07-07', '2021-01-01', 'PB05', 'NV10');

update PHONGBAN set MaTruongPhong = 'NV01', NgayNhanChuc = '2015-01-10' where MaPB = 'PB01';
update PHONGBAN set MaTruongPhong = 'NV04', NgayNhanChuc = '2014-07-01' where MaPB = 'PB02';
update PHONGBAN set MaTruongPhong = 'NV06', NgayNhanChuc = '2017-09-01' where MaPB = 'PB03';
update PHONGBAN set MaTruongPhong = 'NV08', NgayNhanChuc = '2013-04-04' where MaPB = 'PB04';
update PHONGBAN set MaTruongPhong = 'NV10', NgayNhanChuc = '2018-08-08' where MaPB = 'PB05';

insert into DUAN (MaDA, TenDA, NgayBatDau, NgayKetThuc, SoTienThu, MaNVQuanLy) values
('DA01', n'Xây dựng Website Thương mại điện tử', '2024-01-01', '2024-12-31', 500000000, 'NV01'),
('DA02', n'Phát triển Ứng dụng Di động',          '2025-02-01', '2025-10-01', 800000000, 'NV01'),
('DA03', n'Triển khai Hệ thống ERP nội bộ',       '2024-06-01', '2025-03-31', 650000000, 'NV04'),
('DA04', n'Chiến dịch Marketing Số',              '2026-01-15', '2026-08-15', 300000000, 'NV10'),
('DA05', n'Nâng cấp Hạ tầng Mạng',                 '2023-03-01', '2023-09-01', 150000000, 'NV06'),
('DA06', n'Đào tạo Nhân sự Nội bộ',                '2024-04-01', '2024-11-30', 200000000, 'NV06');

insert into PHANCONG (MaNV, MaDA, SoGio) values
('NV01', 'DA01', 200),
('NV01', 'DA02', 180),
('NV02', 'DA01', 350),
('NV02', 'DA02', 150),
('NV03', 'DA01', 400),
('NV03', 'DA02', 500),
('NV04', 'DA03', 300),
('NV05', 'DA03', 450),
('NV05', 'DA01', 100),
('NV06', 'DA05', 250),
('NV06', 'DA06', 200),
('NV07', 'DA05', 300),
('NV07', 'DA06', 350),
('NV10', 'DA04', 280),
('NV11', 'DA04', 320);
insert into PHONGBAN (MaPB, TenPB, MaTruongPhong, NgayNhanChuc) values
('PB01', n'Phòng Kỹ Thuật',   null, null),
('PB02', n'Phòng Kinh Doanh', null, null),
('PB03', n'Phòng Nhân Sự',    null, null),
('PB04', n'Phòng Kế Toán',    null, null),
('PB05', n'Phòng Marketing',  null, null);

insert into NHANVIEN (MaNV, HoTen, DiaChi, Luong, GioiTinh, NgaySinh, NgayVaoLam, MaPB, MaNVQuanLy) values
('NV01', n'Nguyễn Văn An',  n'12 Trần Phú, Đà Nẵng',      30000000, n'Nam', '1980-05-12', '2015-01-10', 'PB01', null),
('NV02', n'Trần Thị Bình',  n'45 Lê Duẩn, Đà Nẵng',       20000000, n'Nữ',  '1990-08-20', '2016-03-15', 'PB01', 'NV01'),
('NV03', n'Lê Văn Cường',   n'8 Nguyễn Chí Thanh, Huế',   32000000, n'Nam', '1985-11-02', '2010-05-20', 'PB01', 'NV01'),
('NV04', n'Phạm Thị Dung',  n'21 Hùng Vương, Đà Nẵng',    28000000, n'Nữ',  '1982-02-14', '2014-07-01', 'PB02', null),
('NV05', n'Hoàng Văn Em',   n'99 Bạch Đằng, Đà Nẵng',     29000000, n'Nam', '1983-09-09', '2012-02-10', 'PB02', 'NV04'),
('NV06', n'Vũ Thị Phương',  n'5 Điện Biên Phủ, Huế',      25000000, n'Nữ',  '1988-04-25', '2017-09-01', 'PB03', null),
('NV07', n'Đặng Văn Giang', n'70 Nguyễn Văn Linh, ĐN',    16000000, n'Nam', '1995-06-30', '2019-11-11', 'PB03', 'NV06'),
('NV08', n'Bùi Thị Hoa',    n'18 Phan Châu Trinh, ĐN',    27000000, n'Nữ',  '1984-01-18', '2013-04-04', 'PB04', null),
('NV09', n'Ngô Văn Ích',    n'33 Ông Ích Khiêm, ĐN',      15000000, n'Nam', '1996-03-03', '2020-06-06', 'PB04', 'NV08'),
('NV10', n'Đỗ Thị Kim',     n'60 Nguyễn Tri Phương, ĐN',  26000000, n'Nữ',  '1987-12-12', '2018-08-08', 'PB05', null),
('NV11', n'Lý Văn Long',    n'14 Trưng Nữ Vương, ĐN',     17000000, n'Nam', '1993-07-07', '2021-01-01', 'PB05', 'NV10');

update PHONGBAN set MaTruongPhong = 'NV01', NgayNhanChuc = '2015-01-10' where MaPB = 'PB01';
update PHONGBAN set MaTruongPhong = 'NV04', NgayNhanChuc = '2014-07-01' where MaPB = 'PB02';
update PHONGBAN set MaTruongPhong = 'NV06', NgayNhanChuc = '2017-09-01' where MaPB = 'PB03';
update PHONGBAN set MaTruongPhong = 'NV08', NgayNhanChuc = '2013-04-04' where MaPB = 'PB04';
update PHONGBAN set MaTruongPhong = 'NV10', NgayNhanChuc = '2018-08-08' where MaPB = 'PB05';

insert into DUAN (MaDA, TenDA, NgayBatDau, NgayKetThuc, SoTienThu, MaNVQuanLy) values
('DA01', n'Xây dựng Website Thương mại điện tử', '2024-01-01', '2024-12-31', 500000000, 'NV01'),
('DA02', n'Phát triển Ứng dụng Di động',          '2025-02-01', '2025-10-01', 800000000, 'NV01'),
('DA03', n'Triển khai Hệ thống ERP nội bộ',       '2024-06-01', '2025-03-31', 650000000, 'NV04'),
('DA04', n'Chiến dịch Marketing Số',              '2026-01-15', '2026-08-15', 300000000, 'NV10'),
('DA05', n'Nâng cấp Hạ tầng Mạng',                 '2023-03-01', '2023-09-01', 150000000, 'NV06'),
('DA06', n'Đào tạo Nhân sự Nội bộ',                '2024-04-01', '2024-11-30', 200000000, 'NV06');

insert into PHANCONG (MaNV, MaDA, SoGio) values
('NV01', 'DA01', 200),
('NV01', 'DA02', 180),
('NV02', 'DA01', 350),
('NV02', 'DA02', 150),
('NV03', 'DA01', 400),
('NV03', 'DA02', 500),
('NV04', 'DA03', 300),
('NV05', 'DA03', 450),
('NV05', 'DA01', 100),
('NV06', 'DA05', 250),
('NV06', 'DA06', 200),
('NV07', 'DA05', 300),
('NV07', 'DA06', 350),
('NV10', 'DA04', 280),
('NV11', 'DA04', 320);

-- PHẦN C. THỰC HIỆN TRUY VẤN

-- Câu 1:
-- Liệt kê các dự án diễn ra trong năm *?*
-- có số tiền thu được trên *?* triệu VND.

set @Nam = 2024;
set @SoTrieu = 400;

select MaDA, TenDA, NgayBatDau, NgayKetThuc, SoTienThu
from DUAN
where year(NgayBatDau) <= @nam
and (NgayKetThuc is null or year(NgayKetThuc) >= @nam)
and SoTienThu > @SoTrieu * 1000000
order by SoTienThu desc; 

-- ------------------------------------------------------------
-- Câu 2:
-- Liệt kê các nhân viên đã tham gia hơn *?* giờ trong các dự án,
-- hiển thị chi tiết số giờ trong mỗi dự án mà nhân viên tham gia.

select nv.MaNV, nv.HoTen, da.MaDA, da.TenDA, pc.SoGio as SoGioTrongDuAn, tg.TongSoGio
from NHANVIEN nv
join PHANCONG pc on nv.MANV = pc.MaNV
join DUAN da on pc.MaDA = da.MaDA
join(
	select MaNV, sum(SoGio) AS TongSoGio
    from PHANCONG
    group by MaNV
    having sum(SoGio) > 500
) tg on nv.MaNV = tg.MaNV
order by nv.MaNV;

-- ------------------------------------------------------------
-- Câu 3:
-- Liệt kê các nhân viên có mức lương >= mức lương của
-- người giám sát/quản lý trực tiếp nhân viên đó.

select nv.MaNV, nv.Luong as LuongNhanVien, ql.HoTen as TenNguoiQuanLy, ql.Luong as LuongNguoiQuanLy
from NHANVIEN nv
join NHANVIEN ql on nv.MaNVQuanLy = ql.MaNv
where nv.Luong >= ql.Luong;




-- ------------------------------------------------------------
-- Câu 4:
-- Liệt kê các phòng ban có số lượng nhân viên lớn hơn *?*.

select pb.MaPB, pb.TenPB, count(nv.MaNV) as SoLuongNhanVien
from PHONGBAN pb
join NHANVIEN nv on pb.MaPB = nv.MaPB
group by pb.MaPB, pb.TenPB
having count(nv.MaNV) > 2;



-- ------------------------------------------------------------
-- Câu 5:
-- Liệt kê các nhân viên đã làm việc cho công ty hơn *?* năm.

select MaNV, HoTen, NgayVaoLam, timestampdiff(year, NgayVaoLam, curdate()) as SoNamLamViec
from NHANVIEN
where curdate() > date_add(NgayVaoLam, interval 10 year)
order by SoNamLamViec desc;



-- ------------------------------------------------------------
-- Câu 6:
-- Liệt kê các nhân viên vừa là trưởng phòng ban,
-- vừa là quản lý dự án.

select nv.MaNV, nv.HoTen, pb.MaPB, pb.TenPB, da.MaDA, da.TenDA
from NHANVIEN nv
join PHONGBAN pb on nv.MaNV = pb.MaTruongPhong
join DUAN da on nv.MaNV = da.MaNVQuanLy;



-- ------------------------------------------------------------
-- Câu 7:
-- Liệt kê các nhân viên quản lý nhiều hơn 1 dự án.

select nv.MaNV, nv.HoTen, count(da.MaDA) as SoDuAnQuanLy
from NHANVIEN nv
join DUAN da on nv.MaNV = da.MaNVQuanLy
group by nv.MaNV, nv.HoTen
having count(da.MaDA) > 1




-- ------------------------------------------------------------
-- Câu 8:
-- Mỗi khi nhân viên tham gia vào dự án, chúng ta cần lưu lại
-- thông tin (log) để biết nhân viên đó tham gia dự án
-- vào thời gian nào.

-- Mỗi khi nhân viên cập nhật số giờ tham gia dự án,
-- cần lưu lại các thông tin:
-- + Thời gian cập nhật.
-- + Số giờ tham gia cũ.
-- + Số giờ tham gia mới.

-- Công việc được thực hiện tự động khi dữ liệu
-- được thêm hoặc cập nhật.


-- video
-- https://youtu.be/XjY-NEWl8ZI
-- https://youtu.be/recDYwYlugU