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

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

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
    public ResponseEntity<TextAnalysisResponse> analyzeText(@RequestBody TextAnalysisRequest request) {
        TextAnalysisResponse response = new TextAnalysisResponse();
        Map<Character, Long> result;

        switch (request.getAnalysisType().toLowerCase(Locale.ROOT)) {
            case "vowels":
                result = textAnalyzerService.analyzeTextForVowels(request.getText());
                break;
            case "consonants":
                result = textAnalyzerService.analyzeTextForConsonants(request.getText());
                break;
            default:
                throw new IllegalArgumentException("Invalid analysis type. Please use 'vowels' or 'consonants'");


        }

        List<String> messages = result.entrySet().stream().map((entry -> String.format("Letter '%s' appears %d times", entry.getKey(), entry.getValue()))).collect(Collectors.toList());

        response.setMessages(messages);
        return ResponseEntity.ok(response);

    }


}
