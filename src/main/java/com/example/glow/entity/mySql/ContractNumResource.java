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
@Table(name = "CONTRACT_NUM", schema = "prod_ins")
public class ContractNumResource {

    private static final long serialVersionUID = 9L;

    @Id
    @Column(name = "CONTRACT_ID")
    private Integer contractId;

    @Column(name = "CONTRACT_NUM")
    private String contractNum;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;

}
