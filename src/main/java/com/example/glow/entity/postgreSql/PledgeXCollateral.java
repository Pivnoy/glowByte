package com.example.glow.entity.postgreSql;

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
@Table(name = "pledge_x_collateral", schema = "prod_loans")
public class PledgeXCollateral {

    @Id
    @Column(name = "pledge_id")
    private Long pledgeId;

    @Column(name = "collateral_id")
    private Long collateralId;

}
