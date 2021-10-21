package com.example.glow.entity.mySql;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENT_CITIZENSHIP", schema = "prod_ins")
public class ClientCitizenshipResource implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @Column(name = "CLIENT_CITIZENSHIP")
    private String clientCitizenship;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;

}
