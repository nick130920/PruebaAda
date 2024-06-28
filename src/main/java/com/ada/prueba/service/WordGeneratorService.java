package com.ada.prueba.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WordGeneratorService {
    private static final Random random = new Random();

    private static final char[] CHAR_ARRAY = {'w','e','r','f','b','h','j','i','u','y','t','r','e','d','f','g','u','t','r','e','s','d','f','g','.','y','u','i','o','1','k','m','n','b','v','.','f','r','e','w','s','x','f','g','y','u','j','k','m','n','b','v','f','r','e','w','w', 'r','t','y','u','i','o','k','m','n','b','v','d','w','s','x','c','f','g','h','u','i','o','p','l','k','n','b','v','f','d','e','w','a','z','x','c','g','h','u','i','o','p','u','y','t','r','e', 'w','w','q','s','d','f','g','k','j','b','v','c','x'};

    public List<String> generateWords(int numWords, int wordLength) {
        List<String> words = new ArrayList<>(numWords);

        for (int j =0; j < numWords; j++) {
            StringBuilder word = new StringBuilder();
            boolean vocal = random.nextBoolean();

            for (int i = 0; i < wordLength; i++) {
                char character;
                if (vocal) {
                    character = getVocal();
                } else {
                    character = getConsonant();
                }
                word.append(character);

                vocal = !vocal;
            }
            words.add(String.valueOf(word));
        }
        return words;
    }

    private static char getVocal() {
        char caracter;
        do {
            caracter = CHAR_ARRAY[random.nextInt(CHAR_ARRAY.length)];
        } while (!isVocal(caracter));
        return caracter;
    }

    private static char getConsonant() {
        char caracter;
        do {
            caracter = CHAR_ARRAY[random.nextInt(CHAR_ARRAY.length)];
        } while (isVocal(caracter) || caracter == '.');
        return caracter;
    }

    private static boolean isVocal(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
