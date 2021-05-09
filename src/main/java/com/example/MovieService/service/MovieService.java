package com.example.MovieService.service;

import com.example.MovieService.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MovieService {

    private static final List<Movie> movieList = List
            .of(new Movie(1L, "Name One"), new Movie(2L, "Name Two"));

    public List<Movie> getAllMovies() {

        return movieList;
    }

    public Movie getMoviesById(Long id) {
        for (Movie movie : movieList) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }

        return null;
    }
}
