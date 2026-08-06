package io.github.marcelosrg.movieflix.controller;

import io.github.marcelosrg.movieflix.dtos.request.MovieRequest;
import io.github.marcelosrg.movieflix.dtos.response.MovieResponse;
import io.github.marcelosrg.movieflix.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movieflix/movie")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        List<MovieResponse> movieResponses = movieService.findAll();
        return ResponseEntity.ok(movieResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable UUID id) {
        MovieResponse movieResponses = movieService.findById(id);
        return ResponseEntity.ok(movieResponses);
    }
    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam String category) {
        List<MovieResponse> movieResponses = movieService.findByCategory(category);
        return ResponseEntity.ok(movieResponses);
    }

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieRequest movieRequest) {

        MovieResponse movieCreated = movieService.createMovie(movieRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(movieCreated);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable UUID id, @RequestBody MovieRequest movieRequest) {
        MovieResponse movieResponses = movieService.updateMovie(id, movieRequest );
        return ResponseEntity.ok(movieResponses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieResponse> delete(@PathVariable UUID id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
