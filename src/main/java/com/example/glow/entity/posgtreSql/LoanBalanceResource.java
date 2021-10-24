package com.example.glow.entity.posgtreSql;

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
@Table(name = "loan_balance", schema = "prod_loans")
public class LoanBalanceResource {

    @Id
    @Column(name = "loan_id")
    private Long loanId;

    @Column(name = "od_amt",precision = 18,scale = 2)
    private Double odAmt;

    @Column(name = "int_amt",precision = 18,scale = 2)
    private Double intAmt;

    @Column(name = "od_overbue_amt",precision = 18,scale = 2)
    private Double odOverbueAmt;

    @Column(name = "int_overbue_amt",precision = 18,scale = 2)
    private Double intOverbueAmt;

    @Column(name = "start_dt")
    private Timestamp startDt;

    @Column(name = "end_dt")
    private Timestamp endDt;

}
