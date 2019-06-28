package com.cbrr.service.function;

import com.cbrr.domain.Function;
import com.cbrr.domain.Movie;
import com.cbrr.dto.FunctionDTO;
import com.cbrr.repository.FunctionRepository;
import com.cbrr.request.FunctionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    FunctionRepository functionRepository;

    @Override
    public List<Function> getAllFunctions() {
        return functionRepository.findAll();
    }

    @Override
    public List<FunctionDTO> getFunctionByMovieId(Long id) {
        return functionRepository.retrieveAllByMovieId(id)
                .stream()
                .map(function->FunctionDTO
                        .builder()
                        .functionId(Long.parseLong(function[0].toString()))
                        .loungeId(Long.parseLong(function[1].toString()))
                        .format(function[2].toString())
                        .schedule(function[3].toString())
                        .seats(Integer.parseInt(function[4].toString()))
                        .price(Double.parseDouble(function[5].toString()))
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public Function getFunction(Long id) {
        return functionRepository.findById(id).orElse(new Function());
    }
}
