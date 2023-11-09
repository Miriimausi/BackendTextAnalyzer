package com.example.TextAnalyzer.controller;

import com.example.TextAnalyzer.model.TextAnalysisRequest;
import com.example.TextAnalyzer.model.TextAnalysisResponse;
import com.example.TextAnalyzer.service.TextAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextAnalyzerController {
    private final TextAnalyzerService textAnalyzerService;

    @Autowired
    public TextAnalyzerController(TextAnalyzerService textAnalyzerService) {
        this.textAnalyzerService = textAnalyzerService;
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/analyze")
    public String analyzeText(String text) {
        return "This text will be analyzed";
    }


    @PostMapping
    public ResponseEntity<TextAnalysisResponse> analyzeText(@RequestBody TextAnalysisRequest request) {
        TextAnalysisResponse response = new TextAnalysisResponse();
        response.setLetter(textAnalyzerService.analyzeText(request.getText()));
        return ResponseEntity.ok(response);
    }
}
