package com.example.TextAnalyzer.controllers;

import com.example.TextAnalyzer.Enum.AnalysisType;
import com.example.TextAnalyzer.models.TextAnalysisRequest;
import com.example.TextAnalyzer.models.TextAnalysisResponse;
import com.example.TextAnalyzer.services.TextAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TextAnalyzerController {
    private final TextAnalyzerService textAnalyzerService;

    @Autowired
    public TextAnalyzerController(TextAnalyzerService textAnalyzerService) {
        this.textAnalyzerService = textAnalyzerService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<TextAnalysisResponse> analyzeText(@RequestBody TextAnalysisRequest request) {
        TextAnalysisResponse response = new TextAnalysisResponse();

        switch (request.getAnalysisType()) {
            case Vowels:
                Map<Character, Long> vowelsResult = textAnalyzerService.analyzeText(request.getText(), AnalysisType.Vowels);
                response.setVowelsResult(vowelsResult);
                break;
            case Consonants:
                Map<Character, Long> consonantsResult = textAnalyzerService.analyzeText(request.getText(), AnalysisType.Consonants);
                response.setConsonantsResult(consonantsResult);
                break;
            case Both:
                response.setVowelsResult(textAnalyzerService.analyzeText(request.getText(), AnalysisType.Vowels));
                response.setConsonantsResult(textAnalyzerService.analyzeText(request.getText(), AnalysisType.Consonants));
                break;
            default:
                throw new IllegalArgumentException("Invalid analysis type. Please use 'vowels', 'consonants', or 'both'");
        }
        return ResponseEntity.ok(response);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}
