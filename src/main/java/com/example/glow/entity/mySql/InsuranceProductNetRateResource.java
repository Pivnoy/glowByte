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
@Table(name = "INSURANCE_PRODUCT_NET_RATE", schema = "prod_ins")
public class InsuranceProductNetRateResource {

    private static final long serialVersionUID = 14L;

    @Id
    @Column(name = "INSURANCE_PRODUCT_ID")
    private Integer insuranceProductId;

    @Column(name = "INSURANCE_PRODUCT_NET_RATE", precision = 12, scale = 4)
    private Double insuranceProductNetRate;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;
}
