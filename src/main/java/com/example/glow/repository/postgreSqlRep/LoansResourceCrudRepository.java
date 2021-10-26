package com.example.glow.repository.postgreSqlRep;

import com.example.glow.entity.postgreSql.LoansResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Implements methods of CRUD repository to connect to postgreSql database
 * and to get Loans table
 */
@Repository
public interface LoansResourceCrudRepository extends CrudRepository<LoansResource, Long> {

}
