package com.example.glow.service;

import com.example.glow.entity.postgreSql.LoansResource;
import com.example.glow.repository.postgreSqlRep.LoansResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 */
@Service
public class LoansResourceDataService {

    private LoansResourceCrudRepository loansResourceCrudRepository;

    @Autowired
    public LoansResourceDataService(LoansResourceCrudRepository loansResourceCrudRepository) {
        this.loansResourceCrudRepository = loansResourceCrudRepository;
    }

    /**
     * Gets all loans from database table Loans
     * @return list of loans from database
     */
    public List<LoansResource>  getAllOutputData(){
        List<LoansResource> loans = new ArrayList<>();
        loansResourceCrudRepository.findAll().forEach(loans::add);
        return loans;
    }
}
