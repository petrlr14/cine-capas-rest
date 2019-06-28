package com.cbrr.service.state;

import com.cbrr.dto.StateDTO;
import com.cbrr.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    StateRepository stateRepository;

    @Override
    public List<StateDTO> getStateAsDTO(String id) {
        List<StateDTO> state = stateRepository.getStateDTO(id)
                .stream()
                .map(obj -> StateDTO.builder()
                        .id(Long.parseLong(obj[0].toString()))
                        .name(obj[1].toString())
                        .ak(obj[2].toString())
                        .build())
                .collect(Collectors.toList());
        return state;
    }
}
