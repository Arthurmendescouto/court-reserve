CREATE TABLE courts(
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       sport_type VARCHAR(20) NOT NULL,
                       price_per_hour DECIMAL(10,2) NOT NULL CHECK (price_per_hour>=0),
                       is_available BOOLEAN DEFAULT TRUE
)