package com.example.glow.service;

import com.example.glow.entity.mySql.ClientResource;
import com.example.glow.repository.mySqlRep.CustomizedClientResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientResourceDataService {

    private CustomizedClientResourceCrudRepository customizedClientResourceCrudRepository;

    @Autowired
    public ClientResourceDataService(CustomizedClientResourceCrudRepository customizedClientResourceCrudRepository) {
        this.customizedClientResourceCrudRepository = customizedClientResourceCrudRepository;
    }

    public List<ClientResource> getAllOutputData(){
        List<ClientResource> retList = new ArrayList<>();
        customizedClientResourceCrudRepository.findAll().forEach(retList::add);
        return retList;
    }
}
