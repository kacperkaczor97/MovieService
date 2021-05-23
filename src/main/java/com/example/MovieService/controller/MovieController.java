package com.example.MovieService.controller;

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
        movieService.getAllMovies();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movieById = movieService.getMoviesById(id);

        if (movieById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movieById);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {

        if (movie == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        movieService.addMovie(movie);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable Long id, @RequestBody Movie movie) {

        Movie moviesById = movieService.getMoviesById(id);

        if (moviesById == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        movieService.updateMovieById(id, movie);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {

        if (movieService.getMoviesById(id) == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        movieService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
