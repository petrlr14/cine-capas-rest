package com.cbrr.service.state;

import com.cbrr.dto.StateDTO;

import java.util.List;

public interface StateService {

    List<StateDTO> getStateAsDTO(String id);

}
