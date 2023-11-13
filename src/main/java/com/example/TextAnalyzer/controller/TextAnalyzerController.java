package com.example.TextAnalyzer.controller;

import com.example.TextAnalyzer.model.TextAnalysisRequest;
import com.example.TextAnalyzer.model.TextAnalysisResponse;
import com.example.TextAnalyzer.service.TextAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
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


    @PostMapping("/analyze")
    public ResponseEntity<TextAnalysisResponse> analyzeText(@RequestBody TextAnalysisRequest request) {
        TextAnalysisResponse response = new TextAnalysisResponse();

        switch (request.getAnalysisType().toLowerCase(Locale.ROOT)) {
            case "vowels":
                Map<Character, Long> vowelsResult = textAnalyzerService.analyzeTextForVowels(request.getText());
                response.setVowelsResult(vowelsResult);
                break;
            case "consonants":
                Map<Character, Long> consonantsResult = textAnalyzerService.analyzeTextForConsonants(request.getText());
                response.setConsonantsResult(consonantsResult);
                break;
            case "both":
                Map<String, Map<Character, Long>> bothResult = textAnalyzerService.analyzeTextForBoth(request.getText());
                response.setVowelsResult(bothResult.get("vowels"));
                response.setConsonantsResult(bothResult.get("consonants"));
                break;
            default:
                throw new IllegalArgumentException("Invalid analysis type. Please use 'vowels', 'consonants', or 'both'");
        }

        return ResponseEntity.ok(response);

    }

    @GetMapping("/text")
    public String getText() {
        return "Hello";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}
