package com.cbrr.service.lounge;

import com.cbrr.domain.Lounge;

import java.util.List;

public interface LoungeService {

    Lounge findOne(Long id);
    List<Lounge> findAll();

}
