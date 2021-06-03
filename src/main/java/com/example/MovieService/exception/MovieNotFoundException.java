package com.example.MovieService.exception;

public class MovieNotFoundException extends Exception {

    public MovieNotFoundException(String id) {
        super("Not found movie with id:" + id);
    }
}
