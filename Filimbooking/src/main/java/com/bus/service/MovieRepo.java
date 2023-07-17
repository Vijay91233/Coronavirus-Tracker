package com.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bus.beans.MovieDetails;


@Repository
public interface MovieRepo extends JpaRepository<MovieDetails, Long> {

    // Add the method for saving the movie details
    @Override
    <S extends MovieDetails> S save(S movie);
}