package com.example.glow.ml;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientForm {

    private String custFio;
    private Long custId;
    private  String custRelationBankType;
    private String custInn;
    private Double custFamilyMonthIncome;
    private Double credAmount;
    private String appSaleChannel;

}
