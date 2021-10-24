package com.example.glow.repository;

import com.example.glow.entity.mySql.ClientResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomizedClientResourceCrudRepository extends CrudRepository<ClientResource,Long> {

    @Query(value = "select * from CLIENT", nativeQuery = true)
    List<ClientResource> loadAllDataBase();

}
