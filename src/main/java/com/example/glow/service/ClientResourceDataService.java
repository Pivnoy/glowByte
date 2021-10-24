package com.example.glow.service;

import com.example.glow.entity.mySql.ClientResource;
import com.example.glow.repository.mySqlRep.CustomizedClientResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 */
@Service
public class ClientResourceDataService {

    private CustomizedClientResourceCrudRepository customizedClientResourceCrudRepository;

    @Autowired
    public ClientResourceDataService(CustomizedClientResourceCrudRepository customizedClientResourceCrudRepository) {
        this.customizedClientResourceCrudRepository = customizedClientResourceCrudRepository;
    }

    /**
     * Gets all clients from database table mySql
     * @return list of all clients from database
     */
    public List<ClientResource> getAllOutputData(){
        List<ClientResource> retList = new ArrayList<>();
        customizedClientResourceCrudRepository.findAll().forEach(retList::add);
        return retList;
    }
}
