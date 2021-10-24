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
@Table(name = "ISUTANCE_CONTRACT_X_CLIENT", schema = "prod_ins")
public class IsutanceContractXClientResource {

    private static final long serialVersionUID = 17L;

    @Id
    @Column(name = "CONTRACT_ID")
    private Long contractId;

    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;
}
