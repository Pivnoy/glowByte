package com.example.glow.entity.mySql;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENT", schema = "prod_ins")
public class ClientResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, name = "CLIENT_ID")
    private Integer clientID;

    @Column(nullable = false, name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;

}
