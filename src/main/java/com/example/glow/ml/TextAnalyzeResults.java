package com.example.glow.ml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TextAnalyzeResults {
    private float confidence;
    private float perseverance;
    private float friendliness;
    private float aggressiveness;
    private float politeness;
}
