package com.cbrr.service.movie;

import com.cbrr.domain.Movie;
import com.cbrr.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll().stream().peek((item)->{
            item.setCreatedByUserID(item.getCreatedByUser().getUserId());
            item.setModifiedByUserID(item.getModifiedByUser().getUserId());
        }).collect(Collectors.toList());
    }

    @Override
    public Movie findById(Long id) {
        Optional<Movie> op=movieRepository.findById(id);
        Movie movie=op.orElse(null);
        if (movie!=null) {
            movie.setCreatedByUserID(movie.getCreatedByUser().getUserId());
            movie.setModifiedByUserID(movie.getModifiedByUser().getUserId());
        }
        return movie;
    }

    @Override
    @Transactional
    public Movie persist(Movie movie) throws DataAccessException{
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public void delete(Long id) throws DataAccessException{
        movieRepository.deleteById(id);
    }

}
