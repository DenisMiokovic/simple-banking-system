CREATE TABLE IF NOT EXISTS customer (
    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS account (
    account_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT,
    account_number VARCHAR(255) UNIQUE,
    account_type VARCHAR(50),
    balance DECIMAL(10, 2),
    past_month_turnover DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE IF NOT EXISTS transaction (
    transaction_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sender_account_id BIGINT,
    receiver_account_id BIGINT,
    amount DECIMAL(19, 2),  -- Adjust precision and scale according to your needs
    currency_id VARCHAR(10),
    message VARCHAR(255),
    timestamp TIMESTAMP,
    FOREIGN KEY (sender_account_id) REFERENCES account(account_id),
    FOREIGN KEY (receiver_account_id) REFERENCES account(account_id)
);