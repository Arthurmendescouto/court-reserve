CREATE TABLE bookings(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id),
    court_id BIGINT NOT NULL REFERENCES courts(id),
    start_time TIMESTAMP NOT NULL,
    CHECK (end_time>start_time)
);