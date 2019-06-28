package com.cbrr.service.province;

import com.cbrr.dto.ProvinceDTO;
import com.cbrr.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<ProvinceDTO> getByStateDTO(String id) {
        return provinceRepository.getProvinceDTO(id)
                .stream()
                .map(province->ProvinceDTO
                        .builder()
                        .id(Long.parseLong(province[0].toString()))
                        .name(province[1].toString())
                        .ak(province[2].toString())
                        .build()
                ).collect(Collectors.toList());
    }
}
