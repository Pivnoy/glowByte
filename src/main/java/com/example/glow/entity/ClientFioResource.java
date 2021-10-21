package com.example.glow.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENT_FIO", schema = "prod_ins")
public class ClientFioResource implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @Column(name = "CLIENT_FIO")
    private String clientFio;

    @Column(name = "EFFECTIVE_FROM_DTTM")
    private Timestamp effectiveFromDttm;

}
