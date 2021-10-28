package com.example.glow.service;

import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.repository.postgreSqlRep.LoanDataResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Service to get list of data from database
 * and pack it into java class to use further
 */
@Service
public class GuarantorDataService {

    private LoanDataResourceCrudRepository loanDataResourceCrudRepository;

    @Autowired
    public GuarantorDataService(LoanDataResourceCrudRepository loanDataResourceCrudRepository){
        this.loanDataResourceCrudRepository = loanDataResourceCrudRepository;
    }

    /**
     * Gets all clients from database table mySql
     * @return list of all application data from database
     */
    public List<ApplicationsResource> getAll(){
        List<ApplicationsResource> res = new ArrayList<>();
        loanDataResourceCrudRepository.findAll().forEach(res::add);
        return res;
    }

}
