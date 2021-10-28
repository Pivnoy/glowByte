package com.example.glow.repository.mySqlRep;

import com.example.glow.entity.mySql.ClientInnResource;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Implements methods of CRUD repository to connect to mySql database
 * and to get all Client Inn
 */
public interface ClientInnResourceCrudRepository extends CrudRepository<ClientInnResource, Long> {

}
