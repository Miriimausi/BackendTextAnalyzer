package com.example.TextAnalyzer.model;

import java.util.Map;

public class TextAnalysisResponse {

    private Map<Character, Long> letter;

    public Map<Character, Long> getLetter(){
        return letter;
    }

    public void setLetter(Map<Character,Long> letter){
        this.letter=letter;
    }
}
