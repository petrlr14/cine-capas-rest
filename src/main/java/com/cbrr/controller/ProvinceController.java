package com.cbrr.controller;

import com.cbrr.dto.ProvinceDTO;
import com.cbrr.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/province", "/province/"})
@CrossOrigin(origins = "*")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    @GetMapping(value = {"/", ""})
    List<ProvinceDTO> getProvinceByStateId(@RequestParam String ak){
        return provinceService.getByStateDTO(ak);
    }

}
