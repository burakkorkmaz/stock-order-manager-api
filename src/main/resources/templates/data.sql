DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS asset;

CREATE TABLE orders (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       customer_id BIGINT NOT NULL,
                       asset_name VARCHAR(255) NOT NULL,
                       order_side VARCHAR(255) NOT NULL, -- BUY or SELL
                       size INT NOT NULL,
                       price DOUBLE NOT NULL,
                       status VARCHAR(255) NOT NULL, -- PENDING, MATCHED, CANCELED
                       create_date TIMESTAMP
);

CREATE TABLE asset (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       customer_id BIGINT NOT NULL,
                       asset_name VARCHAR(255) NOT NULL,
                       size INT NOT NULL, -- Total shares owned
                       usable_size INT NOT NULL -- Available shares
);


INSERT INTO asset (customer_id, asset_name, size, usable_size)
VALUES (1, 'TRY', 10000, 10000),
       (2, 'TRY', 5000, 5000),
       (1, 'AAPL', 100, 100);


INSERT INTO "orders" (customer_id, asset_name, order_side, size, price, status, create_date)
VALUES (1, 'AAPL', 'BUY', 50, 150.00, 'PENDING', CURRENT_TIMESTAMP),
       (2, 'TRY', 'SELL', 100, 1.00, 'PENDING', CURRENT_TIMESTAMP);
