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
@Table(name = "PLEDGE_DISCONT", schema = "prod_ins")
public class PledgeDiscountResource {

    private static final long serialVersionUID = 21L;

    @Id
    @Column(name = "PLEDGE_ID")
    private Integer pledgeId;

    @Column(name = "PLEDGE_DISCONT", precision = 12, scale = 4)
    private Double pledgeDiscont;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;
}
