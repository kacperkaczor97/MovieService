package com.example.MovieService.controller;
import com.example.MovieService.exception.MovieNotFoundException;
import com.example.MovieService.model.Movie;
import com.example.MovieService.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {

        List<Movie> allMovies = movieService.getAllMovies();

        return ResponseEntity.ok(allMovies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) throws MovieNotFoundException {

        Movie movie = movieService.getMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException(String.valueOf(id)));

        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {

        if (movie == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        movie = movieService.addMovie(movie);

        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable Long id, @RequestBody Movie movie)
            throws MovieNotFoundException {

        movieService.getMovieById(id).orElseThrow(() -> new MovieNotFoundException(String.valueOf(id)));

        movieService.updateMovieById(id, movie);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) throws MovieNotFoundException {

        movieService.getMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException(String.valueOf(id)));

        movieService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/changeIsAvailable/{id}")
    public ResponseEntity<Movie> changeIsAvailable(@PathVariable Long id)
            throws MovieNotFoundException {

        movieService.getMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException(String.valueOf(id)));

        movieService.changeIsAvailableToTrue(id);

        return ResponseEntity.ok().build();
    }
}