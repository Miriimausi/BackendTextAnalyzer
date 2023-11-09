package com.example.TextAnalyzer.model;

public class TextAnalysisRequest {

    private String text;
    private String analysisType;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnalysisType() {
        return analysisType;
    }

    public void setAnalysisType(String analysisType) {
        this.analysisType = analysisType;
    }
}
