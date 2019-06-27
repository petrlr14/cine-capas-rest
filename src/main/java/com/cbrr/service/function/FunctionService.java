package com.cbrr.service.function;

import com.cbrr.domain.Function;
import com.cbrr.domain.Movie;
import com.cbrr.request.FunctionForm;

import java.util.List;

public interface FunctionService {

    List<Function> getAllFunctions();
    List<Function> getFunctionByMovieId(Long id);
    Function getFunction(Long id);

}
