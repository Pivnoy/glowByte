package com.example.glow.entity.mySql;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTRACT_OPEN_DT", schema = "prod_ins")
public class ContractOpenDtResource {

    private static final long serialVersionUID = 10L;

    @Id
    @Column(name = "CONTRACT_ID")
    private Integer contractId;

    @Column(name = "CONTRACT_OPEN_DT")
    private Date contractOpenDt;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;
}
