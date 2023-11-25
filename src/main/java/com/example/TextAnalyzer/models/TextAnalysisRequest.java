package com.example.TextAnalyzer.models;

import com.example.TextAnalyzer.enums.AnalysisType;
import lombok.Getter;

@Getter
public class TextAnalysisRequest {
    private String text;
    private AnalysisType analysisType;

    public void setText(String text) {
        this.text = text;
    }

    public void setAnalysisType(AnalysisType analysisType) {
        this.analysisType = analysisType;
    }

}