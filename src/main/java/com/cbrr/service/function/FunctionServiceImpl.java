package com.cbrr.service.function;

import com.cbrr.domain.Function;
import com.cbrr.domain.Movie;
import com.cbrr.repository.FunctionRepository;
import com.cbrr.request.FunctionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    FunctionRepository functionRepository;

    @Override
    public List<Function> getAllFunctions() {
        return functionRepository.findAll();
    }

    @Override
    public List<Function> getFunctionByMovieId(Long id) {
        return functionRepository.findAllByMovieId(id);
    }

    @Override
    public Function getFunction(Long id) {
        return functionRepository.findById(id).orElse(new Function());
    }
}
