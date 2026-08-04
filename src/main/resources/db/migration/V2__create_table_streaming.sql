CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE streaming (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name varchar(150) NOT NULL
);