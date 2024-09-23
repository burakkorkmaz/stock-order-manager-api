CREATE TABLE order (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       customer_id BIGINT NOT NULL,
                       asset_name VARCHAR(255) NOT NULL,
                       order_side VARCHAR(255) NOT NULL, -- BUY or SELL
                       size INT NOT NULL,
                       price DOUBLE NOT NULL,
                       status VARCHAR(255) NOT NULL, -- PENDING, MATCHED, CANCELED
                       create_date TIMESTAMP
);
