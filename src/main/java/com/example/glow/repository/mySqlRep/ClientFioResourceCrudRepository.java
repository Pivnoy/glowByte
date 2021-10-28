package com.example.glow.repository.mySqlRep;

import com.example.glow.entity.mySql.ClientFioResource;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Implements methods of CRUD repository to connect to mySql database
 * and to get all Client Fio
 */
public interface ClientFioResourceCrudRepository extends CrudRepository<ClientFioResource, Long> {
}
