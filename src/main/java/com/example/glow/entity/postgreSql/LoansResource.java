package com.example.glow.entity.postgreSql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loans", schema = "prod_loans")
public class LoansResource {

    @Id
    @Column(name = "loan_id")
    private Long loanId;

    @Column(name = "interest_rate",precision = 12,scale = 4)
    private Double interestRate;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "repayment_mode")
    private String repaymentMode;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "begin_dt")
    private Date beginDt;

    @Column(name = "close_plan_dt")
    private Date closePlanDt;

    @Column(name = "close_fact_dt")
    private Date closeFactDt;
}
