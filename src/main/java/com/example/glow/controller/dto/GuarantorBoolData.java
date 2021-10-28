package com.example.glow.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class GuarantorBoolData {
    private String custFio;
    private String guarantorFio;
    private String guarantorPhone;
    private Date guarantorBirth;
}
