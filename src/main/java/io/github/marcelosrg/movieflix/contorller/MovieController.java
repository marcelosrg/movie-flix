package io.github.marcelosrg.movieflix.contorller;

import io.github.marcelosrg.movieflix.service.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/movieflix/movie")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
}
