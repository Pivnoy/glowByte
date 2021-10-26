package com.example.glow.repository.postgreSqlRep;

import com.example.glow.entity.postgreSql.LoanBalanceResource;
import org.springframework.data.repository.CrudRepository;

public interface LoanBalanceResourceCrudRepository extends CrudRepository<LoanBalanceResource, Long> {
}
