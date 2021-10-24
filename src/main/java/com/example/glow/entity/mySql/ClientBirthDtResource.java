package com.example.glow.entity.mySql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENT_BIRTH_DT", schema = "prod_ins")
public class ClientBirthDtResource implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "CLIENT_BIRTH_DT")
    private Date clientBirthDt;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;

}
