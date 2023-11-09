package com.example.TextAnalyzer.model;

import java.util.List;
import java.util.Map;

public class TextAnalysisResponse {


  private List<String> messages;

    public List<String> getMessages(){
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
