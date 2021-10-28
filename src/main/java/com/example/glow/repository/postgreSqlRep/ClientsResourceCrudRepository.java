package com.example.glow.repository.postgreSqlRep;

import com.example.glow.entity.postgreSql.ClientsResource;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Implements methods of CRUD repository to connect to postgreSql database
 * and to get all Client Fio
 */
public interface ClientsResourceCrudRepository extends CrudRepository<ClientsResource, Long> {
}
