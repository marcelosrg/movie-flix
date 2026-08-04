CREATE TABLE movie_category (
    movie_id UUID   NOT NULL,
    category_id UUID NOT NULL,
    CONSTRAINT fk_movie_category_movie FOREIGN KEY(movie_id) REFERENCES movie(id),
    CONSTRAINT fk_movie_category_category FOREIGN KEY(category_id) REFERENCES category(id)
);