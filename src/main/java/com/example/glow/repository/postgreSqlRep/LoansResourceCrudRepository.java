package com.example.glow.repository.postgreSqlRep;

import com.example.glow.entity.postgreSql.LoansResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansResourceCrudRepository extends CrudRepository<LoansResource, Integer> {

    @Query(value = "select * from prod_loans.loans", nativeQuery = true)
    List<LoansResource> loadAllDataBase();
}
