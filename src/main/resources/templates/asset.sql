CREATE TABLE asset (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       customer_id BIGINT NOT NULL,
                       asset_name VARCHAR(255) NOT NULL,
                       size INT NOT NULL, -- Total shares owned
                       usable_size INT NOT NULL -- Available shares
);
