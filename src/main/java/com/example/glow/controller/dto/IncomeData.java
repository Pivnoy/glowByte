package com.example.glow.controller.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class IncomeData {

    private String custFio;
    private Double custMonthIncome;
    private Double custFamilyMonthIncome;
    private Integer creditsCounts;
    private Double creditSum;

}
