package com.cbrr.service.lounge;

import com.cbrr.domain.Lounge;
import com.cbrr.repository.LoungeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoungeServiceImpl implements LoungeService {

    @Autowired
    LoungeRepository loungeRepository;

    @Override
    public Lounge findOne(Long id) {
        return loungeRepository.findById(id).orElse(new Lounge());
    }

    @Override
    public List<Lounge> findAll() {
        return loungeRepository.findAll();
    }
}
