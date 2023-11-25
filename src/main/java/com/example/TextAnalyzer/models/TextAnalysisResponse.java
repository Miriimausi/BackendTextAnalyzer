package com.example.TextAnalyzer.models;

import lombok.Getter;

import java.util.Map;


@Getter
public class TextAnalysisResponse {

    private Map<Character, Long> vowelsResult;
    private Map<Character, Long> consonantsResult;

    public void setVowelsResult(Map<Character, Long> vowelsResult) {
        this.vowelsResult = vowelsResult;
    }

    public void setConsonantsResult(Map<Character, Long> consonantsResult) {
        this.consonantsResult = consonantsResult;
    }
}
