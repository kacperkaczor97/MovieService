package com.example.MovieService.repository;

import com.example.MovieService.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Override
    List<Movie> findAll();

    @Override
    Optional<Movie> findById(Long aLong);

    @Override
    <S extends Movie> S save(S s);

    @Override
    void deleteById(Long aLong);

}