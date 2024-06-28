package com.ada.prueba.controller;

import com.ada.prueba.service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tmp")
public class TmpController {

    @Autowired
    private TmpService service;

    @GetMapping("/distinct-codigo")
    public List<String> getDistinctCodigoCompanies() {
        return service.getDistinctCodigoCompanies();
    }
}
