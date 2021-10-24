package com.example.glow.entity.posgtreSql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collaterals", schema = "prod_loans")
public class CollateralsResource {

    @Id
    @Column(name = "collateral_id")
    private Long collateralId;

    @Column(name = "collateral_type")
    private String collateralType;

    @Column(name = "collateral_amt",precision = 18,scale = 2)
    private Double collateralAmt;

    @Column(name = "loan_id")
    private Long loanId;

}
