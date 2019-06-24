package com.cbrr.service.movie;

import com.cbrr.domain.Movie;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    Movie findById(Long id);

    Movie persist(Movie movie) throws DataAccessException;

    void delete(Long id) throws DataAccessException;

}
