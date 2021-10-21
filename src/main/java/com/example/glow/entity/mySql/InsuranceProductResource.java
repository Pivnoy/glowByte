package com.example.glow.entity.mySql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INSURANCE_PRODUCT", schema = "prod_ins")
public class InsuranceProductResource implements Serializable {

    private static final long serialVersionUID = 11L;

    @Id
    @Column(name = "INSURANCE_PRODUCT_ID")
    private Integer insuranceProductId;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;
}
