package com.cbrr.service.province;

import com.cbrr.dto.ProvinceDTO;

import java.util.List;

public interface ProvinceService {

    List<ProvinceDTO> getByStateDTO(String ak);

}
