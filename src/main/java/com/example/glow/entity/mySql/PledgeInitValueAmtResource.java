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
@Table(name = "PLEDGE_INIT_VALUE_AMT", schema = "prod_ins")
public class PledgeInitValueAmtResource {

    private static final long serialVersionUID = 22L;

    @Id
    @Column(name = "PLEDGE_ID")
    private Integer pledgeId;

    @Column(name = "PLEDGE_INIT_VALUE_AMT", precision = 18, scale = 2)
    private Double pledgeInitValueAmt;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;
}
