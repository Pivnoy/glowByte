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
    private int aggressiveness;
    private int politeness;
    private int authority;
    private int manipulativeness;
    private int specifics;
    private int brevity;
}
