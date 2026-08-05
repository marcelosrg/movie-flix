package io.github.marcelosrg.movieflix.service;

import io.github.marcelosrg.movieflix.dtos.request.MovieRequest;
import io.github.marcelosrg.movieflix.dtos.response.MovieResponse;
import io.github.marcelosrg.movieflix.entity.Category;
import io.github.marcelosrg.movieflix.entity.Movie;
import io.github.marcelosrg.movieflix.entity.Streaming;
import io.github.marcelosrg.movieflix.exception.NotFoundException;
import io.github.marcelosrg.movieflix.mapper.MovieMapper;
import io.github.marcelosrg.movieflix.repository.CategoryRepository;
import io.github.marcelosrg.movieflix.repository.MovieRepository;
import io.github.marcelosrg.movieflix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final CategoryRepository categoryRepository;
    private final StreamingRepository streamingRepository;

    public MovieService(MovieRepository movieRepository,
                        MovieMapper movieMapper,
                        CategoryRepository categoryRepository,
                        StreamingRepository streamingRepository) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.categoryRepository = categoryRepository;
        this.streamingRepository = streamingRepository;
    }

    public List<MovieResponse> findAll(){
        return movieMapper.toResponseList(movieRepository.findAll());
    }

    public MovieResponse findById(UUID id){
        return movieMapper.toResponse(movieRepository.findById(id).orElseThrow(() -> new NotFoundException("filme não encontrado!")));
    }
    public List<MovieResponse> findByCategory(String category){
        List<Movie> movie = movieRepository.findByCategoryName(category);
        return movieMapper.toResponseList(movie);
    }

    public MovieResponse createMovie(MovieRequest movieRequest) {
        Movie movie = movieMapper.toEntity(movieRequest);

        movie.setCategories(findCategories(movieRequest.categories()));
        movie.setStreamings(findStreamings(movieRequest.streamings()));

        return movieMapper.toResponse(movieRepository.save(movie));
    }

    public MovieResponse updateMovie(UUID movieId, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new NotFoundException("Filme não encontrado!"));
        movie.setTitle(movieRequest.title());
        movie.setDescription(movieRequest.description());
        movie.setRating(movieRequest.rating());
        movie.setReleaseDate(movieRequest.releaseDate());
        movie.setCategories(findCategories(movieRequest.categories()));
        movie.setStreamings(findStreamings(movieRequest.streamings()));
        return movieMapper.toResponse(movieRepository.save(movie));

    }

    public void  deleteMovie(UUID movieId) {
        movieRepository.findById(movieId).orElseThrow(() -> new NotFoundException("Filme não encontrado!"));

        movieRepository.deleteById(movieId);

    }




    private List<Category> findCategories(List<UUID> ids) {
        return ids.stream()
                .map(id -> categoryRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Categoria não encontrada")))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private List<Streaming> findStreamings(List<UUID> ids) {
        return ids.stream()
                .map(id -> streamingRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Streaming não encontrado")))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
