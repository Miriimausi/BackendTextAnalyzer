package com.example.TextAnalyzer.model;

import lombok.Getter;

@Getter
public class TextAnalysisRequest {

    private String text;
    private String analysisType;

    public void setText(String text) {
        this.text = text;
    }

    public void setAnalysisType(String analysisType) {
        this.analysisType = analysisType;
    }
}
