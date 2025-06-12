CREATE DATABASE IF NOT EXISTS telescope_store;
USE telescope_store;

CREATE TABLE telescope_products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100),
    model VARCHAR(50),
    original_price INT,
    discounted_price INT,
    tube_length_cm DECIMAL(4,1),
    focal_length_mm INT,
    weight_kg DECIMAL(3,1),
    aperture_mm INT,
    eyepieces VARCHAR(50),
    additional_info TEXT
);

CREATE USER 'androiduser1'@'%' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON telescope_store.* TO 'androiduser1'@'%';
FLUSH PRIVILEGES;

use telescope_store;
INSERT INTO telescope_products (
    product_name, model, original_price, discounted_price,
    tube_length_cm, focal_length_mm, weight_kg, aperture_mm,
    eyepieces, additional_info
) VALUES
-- 1
('Kính thiên văn Apollo 50mm', 'D50F360', 500000, 450000, 40.0, 360, 0.9, 50, 'H6mm, H20mm', 'Phụ kiện thay đổi theo đợt'),
-- 2
('Kính thiên văn SkyWatcher Explorer', 'D76F900', 1300000, 1150000, 90.0, 900, 2.5, 76, 'H10mm, H25mm', 'Có chân đế EQ1'),
-- 3
('Kính thiên văn Meade Polaris', 'D90F1000', 2200000, 1980000, 100.0, 1000, 3.0, 90, 'H6mm, H9mm, H26mm', 'Bộ ba thị kính tặng kèm'),
-- 4
('Kính thiên văn Celestron AstroMaster', 'D70F900', 1650000, 1500000, 88.0, 900, 2.0, 70, 'H10mm, H20mm', 'Dễ dùng cho người mới bắt đầu'),
-- 5
('Kính thiên văn Bresser Classic', 'D60F700', 1200000, 1050000, 75.0, 700, 1.5, 60, 'Kellner 20mm, 6mm', 'Kèm filter Mặt trăng'),
-- 6
('Kính thiên văn Gskyer AZ70400', 'D70F400', 890000, 799000, 45.0, 400, 1.2, 70, '25mm, 10mm, 5mm', 'Có chân nhôm kèm theo'),
-- 7
('Kính thiên văn Orion GoScope', 'D80F400', 1500000, 1390000, 44.0, 400, 1.4, 80, 'Kellner 20mm, 10mm', 'Ống kính chống lóa'),
-- 8
('Kính thiên văn Tasco SpaceStation', 'D114F900', 2300000, 2100000, 95.0, 900, 4.0, 114, 'SR4mm, H20mm', 'Kèm bản đồ sao'),
-- 9
('Kính thiên văn National Geographic', 'D50F360NG', 980000, 899000, 40.0, 360, 1.0, 50, 'H6mm, H20mm', 'Cho học sinh khám phá thiên văn'),
-- 10
('Kính thiên văn Galileo G-120', 'D120F1000', 3200000, 2950000, 105.0, 1000, 4.8, 120, 'H6mm, H12.5mm, H25mm', 'Quan sát hành tinh rõ nét');
