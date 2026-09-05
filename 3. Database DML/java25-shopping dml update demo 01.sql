SET @@FOREIGN_KEY_CHECKS = 0; -- disable all foreign keys
SET @@FOREIGN_KEY_CHECKS = 1; -- enable all foreign keys
SELECT @@FOREIGN_KEY_CHECKS;

-- DML
-- SELECT
SELECT * FROM t01_item;
SELECT * FROM t02_item_group;
SELECT * FROM t03_sub_item_group;
SELECT * FROM t04_size;

-- TRUNCATE [DDL]
TRUNCATE TABLE t02_item_group;

-- DELETE [DML]
DELETE FROM t02_item_group;
DELETE FROM t02_item_group WHERE C02_ITEM_GROUP_ID = 6;
DELETE FROM t03_sub_item_group;

-- Phân biệt TRUNCATE và DELETE

-- 1. TRUNCATE
-- DDL
-- Muốn xóa được thì bắt buộc phải disable/remove FK(s) liên quan, ko quan tâm đến dữ liệu
-- Xóa toàn bộ dữ liệu của TABLE và reset về các cầu hình mặc định(ví dụ AUTO_INCREMENT)

-- 2. DELETE
-- DML
-- Khi xóa dữ liệu, nếu table là table cha, dòng dữ liệu cần xóa ko bị tham chiếu bởi table con thì xóa thoải mái,
-- trường hợp dữ liệu cần xóa đang bị tham chiếu ở table con, thì [xóa luôn ở table con || báo lỗi ==> configuration]
-- Xóa 1/N/ALL dòng dữ liệu
-- Không reset AUTO_INCREMENT

-- Tiếp tục với DELETE
DELETE FROM t02_item_group WHERE C02_ITEM_GROUP_ID = 50;
DELETE FROM t02_item_group WHERE C02_ITEM_GROUP_ID IN (51, 52, 53);

DELETE FROM t02_item_group WHERE C02_ITEM_GROUP_ID = 5; -- TEST FOR RESTRICT

DELETE FROM t02_item_group WHERE C02_ITEM_GROUP_ID = 7; -- TEST FOR CASCADE

-- INSERT: Cách 1
INSERT INTO t02_item_group(C02_ITEM_GROUP_NAME, C02_STATUS)
VALUES ('Loại Hàng 1', 1),
       ('Loại Hàng 2', 1),
       ('Loại Hàng 3', 1),
       ('Loại Hàng 4', 0),
       ('Loại Hàng 5', 1);
       
INSERT INTO t02_item_group(C02_ITEM_GROUP_NAME, c02_status)
VALUES ('Loại Hàng 6x', 0);

INSERT INTO t03_sub_item_group(C03_SIG_ID, C03_SIG_NAME, C03_ITEM_GROUP_ID)
VALUES (11, 'LHC 11', 1), (12, 'LHC 12', 1),
       (13, 'LHC 13', 3), (14, 'LHC 14', 3),
       (15, 'LHC 15', 5), (16, 'LHC 16', 5),
       -- (17, 'LHC 17', 7), (18, 'LHC 18', 7),
       (19, 'LHC 19', 9), (20, 'LHC 20', 9);

INSERT INTO t04_size(C04_SIZE_ID, C04_SIZE_NAME, C04_GENDER, C04_SIZE_DESC) VALUES
(1, 'S', 0, 'Size S cho KH Nữ'),
(2, 'M', 0, 'Size M cho KH Nữ'),
(3, 'L', 0, 'Size L cho KH Nữ'),
(4, 'S', 1, 'Size S cho KH Nam'),
(5, 'M', 1, 'Size M cho KH Nam'),
(6, 'L', 1, 'Size L cho KH Nam');

INSERT INTO t01_item(C01_ITEM_ID, C01_ITEM_NAME, C01_BUY_PRICE, C01_MATERIAL, C01_COLOR, C01_SIG_ID, C01_ITEM_GROUP_ID) VALUES
(1, 'Item A1', 120, 'Mx', 'Cy', null, 20),
(2, 'Item A2', 140, 'Mx', 'Cy', null, 20),
(3, 'Item A3', 160, 'Mx', 'Cy', null, 21),
(4, 'Item A4', 180, 'Mx', 'Cy', null, 21),
(5, 'Item A5', 200, 'Mx', 'Cy', null, 22),
(6, 'Item A6', 300, 'Mx', 'Cy', 11, 1),
(7, 'Item A7', 305, 'Mx', 'Cy', 11, 1);

       

-- INSERT: Cách 2(dummy data) cte(common table expression): được dùng trong scope của 1 lệnh SQL
INSERT INTO t02_item_group(C02_ITEM_GROUP_NAME, C02_STATUS)
WITH cte_item_group AS (
	SELECT 'Loại Hàng X4' DMD_GROUP_NAME, 1 DMD_STATUS
	UNION
	SELECT 'Loại Hàng X5', 1
	UNION
	SELECT 'Loại Hàng X6', 0
)
SELECT * FROM cte_item_group WHERE DMD_STATUS = 1;

-- Thêm dữ liệu từ cte_item_group với status=1 vào table t02_item_group

-- INSERT: Cách 3(insert 1 lượng lớn dự liệu với công thức nào đó)
--       : 100 loại hàng 1-100, loại hàng 1-100, status random(0,1)

CALL p_insert_into_group(100);

-- UPDATE
UPDATE t03_sub_item_group
   SET C03_SIG_NAME = '1111'
WHERE C03_SIG_ID = 11;

UPDATE t03_sub_item_group
   SET C03_ITEM_GROUP_ID = 1;
   
-- Xử lý trường hợp, lỡ tay cập nhật/xóa toàn bộ dữ liệu của 1/N tables
-- Mặc định: auto_commit = true
-- Muốn reset lại dữ liệu
-- 1. set auto_commit = false
-- 2. ok -> commit
--    x  -> rollback

-- set mode
SET @@autocommit = 0;
SET @@autocommit = 1;
SELECT @@autocommit;

commit;
rollback;

-- delete
-- insert
-- update
-- saveOrUpdate, merge
   
-- Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column. 
-- To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.