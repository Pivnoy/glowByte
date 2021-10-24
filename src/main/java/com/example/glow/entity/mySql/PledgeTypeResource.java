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
@Table(name = "PLEDGE_TYPE", schema = "prod_ins")
public class PledgeTypeResource {

    private static final long serialVersionUID = 23L;

    @Id
    @Column(name = "PLEDGE_ID")
    private Long pledgeId;

    @Column(name = "PLEDGE_TYPE")
    private String pledgeType;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;
}
