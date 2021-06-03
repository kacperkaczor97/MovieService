package com.example.MovieService.handlerexception;

import com.example.MovieService.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {


    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleException(MovieNotFoundException notFoundMovieException) {
        String exceptionMessage =
                "Exception occurred on request. Exception message: " + notFoundMovieException.getMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMessage);
    }


}
