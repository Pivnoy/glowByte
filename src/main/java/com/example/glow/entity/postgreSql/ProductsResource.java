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
@Table(name = "products", schema = "prod_loans")
public class ProductsResource {

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_1_group")
    private String product1Group;

    @Column(name = "product_2_group")
    private String product2Group;

    @Column(name = "product_3_group")
    private String product3Group;

}
