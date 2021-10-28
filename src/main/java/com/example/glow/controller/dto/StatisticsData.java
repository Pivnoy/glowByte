package com.example.glow.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatisticsData {

    private Double creditSum;
    private Integer clientNumber;
    private Double guarantorPercent;
    private Double middleIncome;

}
