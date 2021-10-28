package com.example.glow.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class GuarantorData {

    private String custFio;
    private String guarantorFio;
    private Boolean guarantorFlag;
    private String guarantorPhone;
    private Date guarantorBirth;

}
