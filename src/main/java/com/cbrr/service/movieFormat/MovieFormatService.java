package com.cbrr.service.movieFormat;

import com.cbrr.domain.MovieFormat;

import java.util.List;

public interface MovieFormatService {

    MovieFormat findOneMovieFormat(Long id);
    List<MovieFormat> findAll();
}
