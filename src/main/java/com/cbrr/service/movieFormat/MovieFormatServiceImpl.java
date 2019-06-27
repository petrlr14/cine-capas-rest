package com.cbrr.service.movieFormat;

import com.cbrr.domain.MovieFormat;
import com.cbrr.repository.MovieFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieFormatServiceImpl implements MovieFormatService {

    @Autowired
    MovieFormatRepository movieFormatRepository;

    @Override
    public MovieFormat findOneMovieFormat(Long id) {
        return movieFormatRepository.findById(id).orElse(new MovieFormat());
    }

    @Override
    public List<MovieFormat> findAll() {
        return movieFormatRepository.findAll();
    }
}
