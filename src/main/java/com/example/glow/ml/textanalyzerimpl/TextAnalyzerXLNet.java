package com.example.glow.ml.textanalyzerimpl;

import com.example.glow.ml.TextAnalyzeResults;
import com.example.glow.ml.TextAnalyzer;
import com.example.glow.ml.TextEntity;

import java.util.Random;

public class TextAnalyzerXLNet implements TextAnalyzer {

    private static Random random = new Random();

    @Override
    public TextAnalyzeResults analyzeText(TextEntity text) {
        int aggressiveness = random.nextInt(100);
        int politeness = random.nextInt(100);
        int authority = random.nextInt(100);
        int manipulativeness = random.nextInt(100);
        int specifics = random.nextInt(100);
        int brevity = random.nextInt(100);
        return new TextAnalyzeResults(aggressiveness, politeness, authority, manipulativeness, specifics, brevity);
    }
}
