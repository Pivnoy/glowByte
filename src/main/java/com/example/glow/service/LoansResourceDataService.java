package com.example.glow.service;

import com.example.glow.entity.postgreSql.LoansResource;
import com.example.glow.repository.postgreSqlRep.LoansResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoansResourceDataService {

    private LoansResourceCrudRepository loansResourceCrudRepository;

    @Autowired
    public LoansResourceDataService(LoansResourceCrudRepository loansResourceCrudRepository) {
        this.loansResourceCrudRepository = loansResourceCrudRepository;
    }

    public List<LoansResource>  getAllOutputData(){
        List<LoansResource> loans = new ArrayList<>();
        loansResourceCrudRepository.findAll().forEach(loans::add);
        return loans;
    }
}
