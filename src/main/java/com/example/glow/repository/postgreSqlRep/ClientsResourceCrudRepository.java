package com.example.glow.repository.postgreSqlRep;

import com.example.glow.entity.postgreSql.ClientsResource;
import org.springframework.data.repository.CrudRepository;

public interface ClientsResourceCrudRepository extends CrudRepository<ClientsResource, Long> {
}
