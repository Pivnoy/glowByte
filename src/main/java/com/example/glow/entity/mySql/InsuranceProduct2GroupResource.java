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
@Table(name = "INSURANCE_PRODUCT_2_GROUP", schema = "prod_ins")
public class InsuranceProduct2GroupResource {

    private static final long serialVersionUID = 12L;

    @Id
    @Column(name = "INSURANCE_PRODUCT_ID")
    private Integer insuranceProductId;

    @Column(name = "INSURANCE_PRODUCT_2_GROUP")
    private String insuranceProduct2Group;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;

}
