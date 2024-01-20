CREATE TABLE IF NOT EXISTS task (
    id BIGINT PRIMARY KEY,
    description VARCHAR(255),
    status VARCHAR(50),
    deadline VARCHAR(50)
    );