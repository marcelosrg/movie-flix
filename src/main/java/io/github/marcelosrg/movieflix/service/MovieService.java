package io.github.marcelosrg.movieflix.service;

import io.github.marcelosrg.movieflix.dtos.request.MovieRequest;
import io.github.marcelosrg.movieflix.dtos.response.MovieResponse;
import io.github.marcelosrg.movieflix.mapper.MovieMapper;
import io.github.marcelosrg.movieflix.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    public MovieService(MovieRepository movieRepository,
                        MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public MovieResponse createMovie(MovieRequest movieRequest) {
        return movieMapper.toResponse(movieRepository.save(movieMapper.toEntity(movieRequest)));
    }

    public List<MovieResponse> findAll(){
        return movieMapper.toResponseList(movieRepository.findAll());
    }

}
