package com.example.glow.entity.mySql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INSURANCE_PRODUCT_RISK", schema = "prod_ins")
public class InsuranceProductRiskResource {

    private static final long serialVersionUID = 15L;

    @Id
    @Column(name = "INSURANCE_PRODUCT_ID")
    private Long insuranceProductId;

    @Column(name = "INSURANCE_PRODUCT_RISK", precision = 12, scale = 4)
    private Double insuranceProductRisk;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;
}
