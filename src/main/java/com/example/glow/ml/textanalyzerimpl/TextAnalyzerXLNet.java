package com.example.glow.ml.textanalyzerimpl;

import com.example.glow.ml.TextAnalyzeResults;
import com.example.glow.ml.TextAnalyzer;
import com.example.glow.ml.TextEntity;

import java.util.Random;

public class TextAnalyzerXLNet implements TextAnalyzer {

    private static Random random = new Random();

    @Override
    public TextAnalyzeResults analyzeText(TextEntity text) {
        int aggressiveness = text.hashCode() % 100;
        int politeness = Integer.toBinaryString(aggressiveness).hashCode() % 100;
        int authority = Integer.toBinaryString(politeness).hashCode() % 100;
        int manipulativeness = Integer.toBinaryString(authority).hashCode() % 100;
        int specifics = Integer.toBinaryString(manipulativeness).hashCode() % 100;
        int brevity = Integer.toBinaryString(specifics).hashCode() % 100;
        return new TextAnalyzeResults(aggressiveness, politeness, authority, manipulativeness, specifics, brevity);
    }
}
