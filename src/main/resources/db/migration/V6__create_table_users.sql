CREATE TABLE users(
    id       UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name     varchar(255) NOT NULL,
    email    varchar(255) NOT NULL,
    password varchar(255) NOT NULL
)