package com.ada.prueba.service;

import com.ada.prueba.repository.TmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmpService {

    @Autowired
    private TmpRepository tmpRepository;

    public List<String> getDistinctCodigoCompanies() {
        return tmpRepository.findDistinctCodigoCompany();
    }
}
