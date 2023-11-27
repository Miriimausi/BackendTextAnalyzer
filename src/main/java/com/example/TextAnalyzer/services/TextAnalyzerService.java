package com.example.TextAnalyzer.services;

import com.example.TextAnalyzer.enums.AnalysisType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class TextAnalyzerService {
    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    private Map<AnalysisType, Map<Character, Long>> countCharacters(String text) {
        Map<Character, Long> countedVowels = new HashMap<>();
        Map<Character, Long> countedConsonants = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                Map<Character, Long> targetMap = isVowel(c) ? countedVowels : countedConsonants;
                targetMap.merge(Character.toLowerCase(c), 1L, Long::sum);
            }
        }


        Map<AnalysisType, Map<Character, Long>> result = new HashMap<>();
        result.put(AnalysisType.Vowels, countedVowels);
        result.put(AnalysisType.Consonants, countedConsonants);
        return result;
    }

    public Map<Character, Long> analyzeText(String text, AnalysisType analysisType) {
        Map<AnalysisType, Map<Character, Long>> results = countCharacters(text);
        return results.getOrDefault(analysisType, new HashMap<>());
    }

}
