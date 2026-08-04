CREATE TABLE movie (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    title varchar(255) NOT NULL,
    description text,
    release_date date,
    rating numeric,
    created_at timestamp,
    updated_at timestamp
);