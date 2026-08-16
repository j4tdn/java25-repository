-- DML
-- SELECT
SELECT * FROM t02_item_group;

-- INSERT
INSERT INTO t02_item_group(C02_ITEM_GROUP_ID, C02_ITEM_GROUP_NAME, C02_STATUS)
VALUES (1, 'Loại Hàng 1', 1),
       (2, 'Loại Hàng 2', 1),
       (3, 'Loại Hàng 3', 1),
       (4, 'Loại Hàng 4', 0),
       (5, 'Loại Hàng 5', 1);
       
INSERT INTO t02_item_group(C02_ITEM_GROUP_NAME, C02_STATUS)
VALUES ('Loại Hàng 6', 1),

