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
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applications", schema = "prod_apps")
public class ApplicationsResource {

    @Id
    @Column(name = "app_id")
    private Long appId;

    @Column(name = "app_date")
    private Timestamp appDate;

    @Column(name = "cred_amount", precision = 18, scale = 2)
    private Double credAmount;

    @Column(name = "cred_term")
    private Timestamp credTerm;

    @Column(name = "cred_object")
    private String credObject;

    @Column(name = "cust_month_income", precision = 18, scale = 2)
    private Double custMonthIncome;

    @Column(name = "cust_family_month_income", precision = 18, scale = 2)
    private Double custFamilyMonthIncome;

    @Column(name = "cust_fio")
    private String custFio;

    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_birth")
    private Date custBitrh;

    @Column(name = "cust_inn")
    private String custInn;

    @Column(name = "guarantor_flag")
    private Boolean guarantorFlag;

    @Column(name = "guarantor_fio")
    private String guarantorFio;

    @Column(name = "guarantor_phone")
    private String guarantorPhone;

    @Column(name = "guarantor_birth")
    private Date guarantorBirth;

    @Column(name = "pledge_amount", precision = 18, scale = 2)
    private Double pledgeAmount;

    @Column(name = "pledge_type")
    private String pledgeType;

    @Column(name = "interview_datetime")
    private Timestamp interviewDatetime;

    @Column(name = "cust_relation_bank_type")
    private String custRelationBankType;

    @Column(name = "app_sale_channel")
    private String appSaleChannel;



}
