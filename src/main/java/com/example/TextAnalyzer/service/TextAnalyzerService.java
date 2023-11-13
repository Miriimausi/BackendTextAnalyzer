package com.example.TextAnalyzer.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * The program for calculating how many times a letter in given sentence appears.
 * It gives numbers either for vowels or for consonants based on program input.
 * <p>
 * The first parameter can be 'vowels' or 'consonants'
 * The second parameter is the sentence to be analyzed.
 * <p>
 * Task: Refactor this code to be production ready and create appropriate unit tests.
 */
@Service
public class TextAnalyzerService {
    public Map<Character, Long> analyzeTextForVowels(String text) {
        Map<Character, Long> countedVowels = new HashMap<>();
        char[] chars = text.toCharArray();

        for (char c : chars) {
            if (isVowel(c)) {
                countedVowels.merge(Character.toLowerCase(c), 1L, Long::sum);
            }
        }
        return countedVowels;
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1L;
    }


    public Map<Character, Long> analyzeTextForConsonants(String text) {
        Map<Character, Long> countedConsonants = new HashMap<>();
        char[] chars = text.toCharArray();

        for (char c : chars) {
            if (!isVowel(c) && Character.isLetter(c)) {
                countedConsonants.merge(Character.toLowerCase(c), 1L, Long::sum);

            }
        }
        return countedConsonants;
    }

    public Map<String, Map<Character, Long>> analyzeTextForBoth(String text) {
        Map<Character,Long> countedVowels = new HashMap<>();
        Map<Character, Long> countedConsonants = new HashMap<>();
        char[] chars = text.toCharArray();

        for (char c: chars){
            if (isVowel(c)){
                countedVowels.merge(Character.toLowerCase(c), 1L, Long::sum);
            } else if (Character.isLetter(c)) {
                countedConsonants.merge(Character.toLowerCase(c), 1L, Long::sum);

            }
        }
        Map<String, Map<Character, Long>> result = new HashMap<>();
        result.put("vowels", countedVowels);
        result.put("consonants", countedConsonants);
        return result;
    }
}
