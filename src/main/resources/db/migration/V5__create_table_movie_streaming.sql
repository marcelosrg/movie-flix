CREATE TABLE movie_streaming (
    movie_id UUID NOT NULL,
    streaming_id UUID NOT NULL,
    CONSTRAINT fk_movie_streaming_movie FOREIGN KEY(movie_id) REFERENCES movie(id),
    CONSTRAINT fk_movie_streaming_streaming FOREIGN KEY(streaming_id) REFERENCES streaming(id)
);