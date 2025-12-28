-- Products Table
CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL PRIMARY KEY,
    product_code VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(12,2) NOT NULL,
    stock_quantity INTEGER NOT NULL DEFAULT 0
);

-- Orders Table
CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    order_number VARCHAR(50) UNIQUE NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    total_amount DECIMAL(12,2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- 25 DUMMY PRODUCTS (Realistic E-Commerce Catalog)
INSERT INTO products (product_code, name, description, price, stock_quantity) 
VALUES 

('LAP001', 'Dell XPS 13', 'Premium Ultrabook - Intel i7, 16GB RAM', 95000.00, 25),
('LAP002', 'MacBook Air M2', 'Apple Silicon - 8GB RAM, 256GB SSD', 115000.00, 12),
('LAP003', 'HP Pavilion 15', 'Everyday laptop - AMD Ryzen 5, 8GB RAM', 55000.00, 35),
('LAP004', 'Lenovo ThinkPad X1', 'Business Carbon - Intel i7, 32GB RAM', 145000.00, 8),
('LAP005', 'ASUS ROG Strix', 'Gaming Laptop - RTX 4060, Intel i9', 185000.00, 5),
('PHN001', 'iPhone 15 Pro', 'Latest flagship - 256GB, Titanium', 115000.00, 15),
('PHN002', 'Samsung S24 Ultra', 'AI Camera - 12GB RAM, 512GB', 125000.00, 20),
('PHN003', 'OnePlus 12', '120Hz AMOLED - Snapdragon 8 Gen 3', 65000.00, 30),
('PHN004', 'Google Pixel 8 Pro', 'Best Camera - Tensor G3, 128GB', 95000.00, 18),
('PHN005', 'Nothing Phone 2', 'Glyph Interface - 12GB RAM', 45000.00, 40),
('TAB001', 'iPad Pro 12.9 M2', 'Professional tablet - 256GB', 95000.00, 10),
('TAB002', 'Samsung Galaxy Tab S9', 'S Pen included - 12GB RAM', 75000.00, 15),
('TAB003', 'Lenovo Tab P11 Pro', '2K Display - 8GB RAM', 35000.00, 25),
('AUD001', 'Sony WH-1000XM5', 'Noise Cancelling Headphones', 28000.00, 45),
('AUD002', 'Apple AirPods Pro 2', 'Spatial Audio - USB-C', 22000.00, 60),
('AUD003', 'JBL Flip 6', 'Portable Bluetooth Speaker', 8500.00, 80),
('ACC001', 'Apple Watch Series 9', 'Health tracking - 41mm GPS', 38000.00, 35),
('ACC002', 'Logitech MX Master 3S', 'Wireless mouse - Multi-device', 9500.00, 70),
('ACC003', 'Anker 65W Charger', 'GaN Fast Charging - 3 Ports', 3500.00, 120),
('ACC004', 'Samsung 1TB SSD', 'NVMe M.2 - 7000MB/s read', 8500.00, 50),
('HAP001', 'Dyson V15 Detect', 'Cordless Vacuum - Laser Detection', 65000.00, 8),
('HAP002', 'Philips Air Fryer XL', '6.2L Capacity - 2000W', 14500.00, 25)

ON CONFLICT (product_code) DO NOTHING;
