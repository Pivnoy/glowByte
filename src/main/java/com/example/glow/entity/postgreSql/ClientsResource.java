package com.example.glow.entity.postgreSql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients", schema = "prod_loans")
public class ClientsResource {

    @Id
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "fio")
    private String fio;

    @Column(name = "birth_dt")
    private Date birthDt;

    @Column(name = "inn")
    private String inn;

    @Column(name = "citizenship")
    private String citizenship;

}
