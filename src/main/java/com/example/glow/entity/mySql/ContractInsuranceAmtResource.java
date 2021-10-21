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
@Table(name = "CONTRACT_INSURANCE_AMT", schema = "prod_ins")
public class ContractInsuranceAmtResource implements Serializable {

    private static final long serialVersionUID = 7L;

    @Id
    @Column(name = "CONTRACT_ID")
    private Integer contractId;

    @Column(name = "CONTRACT_INSURANCE_AMT", precision = 18, scale = 2)
    private Double contractInsuranceAmt;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;
}
