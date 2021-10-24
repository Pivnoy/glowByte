package com.example.glow.repository.mySqlRep;

import com.example.glow.entity.mySql.ClientResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Implements methods of CRUD repository to connect to mySql database
 * and to get Client table
 */
@Repository
public interface CustomizedClientResourceCrudRepository extends CrudRepository<ClientResource,Long> {


}
