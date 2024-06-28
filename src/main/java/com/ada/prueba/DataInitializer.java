package com.ada.prueba;

import com.ada.prueba.entity.TmpLlenarCampos;
import com.ada.prueba.service.DataInsertionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {


    private DataInsertionService dataInsertionService;



    @Override
    public void run(String... args) throws Exception {
        dataInsertionService.insertData();
        log.info("Procedimiento de inserción Correcto");
    }
}
