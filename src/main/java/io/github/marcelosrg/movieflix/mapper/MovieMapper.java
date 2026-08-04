package io.github.marcelosrg.movieflix.mapper;

import io.github.marcelosrg.movieflix.dtos.request.MovieRequest;
import io.github.marcelosrg.movieflix.dtos.response.MovieResponse;
import io.github.marcelosrg.movieflix.entity.Category;
import io.github.marcelosrg.movieflix.entity.Movie;
import io.github.marcelosrg.movieflix.entity.Streaming;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    private final CategoryMapper categoryMapper;
    private final StreamingMapper streamingMapper;

    public MovieMapper(CategoryMapper categoryMapper, StreamingMapper streamingMapper) {
        this.categoryMapper = categoryMapper;
        this.streamingMapper = streamingMapper;
    }

    public Movie toEntity(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setTitle(movieRequest.title());
        movie.setReleaseDate(movieRequest.releaseDate());
        movie.setRating(movieRequest.rating());
        movie.setDescription(movieRequest.description());

        List<Category> categories = movieRequest.categories().stream()
                .map(categoryId -> {
                    Category category = new Category();
                    category.setId(categoryId);
                    return category;
                })
                .toList();
        movie.setCategories(categories);

        List<Streaming> streamings = movieRequest.streamings().stream()
                .map(streamingId -> {
                    Streaming streaming = new Streaming();
                    streaming.setId(streamingId);
                    return streaming;
                })
                .toList();
        movie.setStreamings(streamings);

        return movie;
    }

    public MovieResponse toResponse(Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getReleaseDate(),
                movie.getRating(),
                categoryMapper.toResponseList(movie.getCategories()),
                streamingMapper.toResponseList(movie.getStreamings()),
                movie.getCreatedAt(),
                movie.getUpdatedAt()
        );
    }

    public List<MovieResponse> toResponseList(List<Movie> movies) {
        return movies.stream()
                .map(this::toResponse)
                .toList();
    }
}