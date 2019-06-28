package com.cbrr.service.function;

import com.cbrr.domain.Function;
import com.cbrr.dto.FunctionDTO;

import java.util.List;

public interface FunctionService {

    List<Function> getAllFunctions();
    List<FunctionDTO> getFunctionByMovieId(Long id);
    Function getFunction(Long id);

}
