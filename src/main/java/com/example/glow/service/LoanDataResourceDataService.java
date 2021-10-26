package com.example.glow.service;


import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.repository.postgreSqlRep.LoanDataResourceCrudRepository;
import com.example.glow.repository.postgreSqlRep.LoansResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanDataResourceDataService {

    private LoanDataResourceCrudRepository loanDataResourceCrudRepository;

    @Autowired
    public LoanDataResourceDataService(LoanDataResourceCrudRepository loanDataResourceCrudRepository) {
        this.loanDataResourceCrudRepository = loanDataResourceCrudRepository;
    }

    public List<ApplicationsResource> getAll() {
        List<ApplicationsResource> nm = new ArrayList<>();
        loanDataResourceCrudRepository.findAll().forEach(nm::add);
        return nm;
    }
}
