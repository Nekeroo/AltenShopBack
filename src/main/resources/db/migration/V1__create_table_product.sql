CREATE TABLE IF NOT EXISTS product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_product BIGINT NOT NULL,
    code VARCHAR(50) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    category VARCHAR(100),
    image VARCHAR(255),
    internal_reference VARCHAR(100),
    shell_id INT,
    inventory_status VARCHAR(50),
    rating DECIMAL(2, 1),
    created_at LONG,
    updated_at LONG,
    PRIMARY KEY (id)
)