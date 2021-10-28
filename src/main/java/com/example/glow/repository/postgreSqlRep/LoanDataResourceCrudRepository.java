package com.example.glow.repository.postgreSqlRep;

import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.entity.postgreSql.LoansResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Implements methods of CRUD repository to connect to postgreSql database
 * and to get multiple data about loans from different
 * entities
 */
public interface LoanDataResourceCrudRepository extends CrudRepository<ApplicationsResource, Long> {

}
