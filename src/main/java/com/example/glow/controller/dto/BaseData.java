package com.example.glow.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class BaseData {

    private String custFio;
    private Long custId;
    private Long custBirth;
    private String custInn;

}
