package com.example.glow.controller.dto;

import lombok.Builder;
import lombok.Data;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class LoansData {

    private Long appId;
    private String custFio;
    private Timestamp appDate;
    private Double credAmount;
    private Long credTerm;
    private String credObject;

}
