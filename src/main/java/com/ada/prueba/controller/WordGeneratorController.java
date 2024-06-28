package com.ada.prueba.controller;

import com.ada.prueba.service.WordGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WordGeneratorController {

    private WordGeneratorService wordGeneratorService;


    @GetMapping("/generate-words")
    public List<String> generateWords(
            @RequestParam(name = "numWords", defaultValue = "5") int numWords,
            @RequestParam(name = "wordLength", defaultValue = "6") int wordLength) {
        return wordGeneratorService.generateWords(numWords, wordLength);
    }
}
