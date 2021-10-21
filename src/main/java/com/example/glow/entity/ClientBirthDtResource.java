package com.example.glow.entity;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "CLIENT_BIRTH_DT", schema = "prod_ins")
public class ClientBirthDtResource {

    @Id
    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @Column(name = "CLIENT_BIRTH_DT")
    private Date clientBirthDt;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;


}
