package com.example.glow.service;


import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.repository.postgreSqlRep.LoanDataResourceCrudRepository;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
=======
import com.example.glow.repository.postgreSqlRep.LoansResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> d89e0f175f4666bd0df5121d7a988e3b016e233f

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Service to get list of data from database
 * and pack it into java class to use further
 */
=======
>>>>>>> d89e0f175f4666bd0df5121d7a988e3b016e233f
@Service
public class LoanDataResourceDataService {

    private LoanDataResourceCrudRepository loanDataResourceCrudRepository;

    @Autowired
    public LoanDataResourceDataService(LoanDataResourceCrudRepository loanDataResourceCrudRepository) {
        this.loanDataResourceCrudRepository = loanDataResourceCrudRepository;
    }

<<<<<<< HEAD
    /**
     * Calculate multiple data from different mySql tables,
     * and combine them together
     * @return list of all applications
     */
=======
>>>>>>> d89e0f175f4666bd0df5121d7a988e3b016e233f
    public List<ApplicationsResource> getAll() {
        List<ApplicationsResource> nm = new ArrayList<>();
        loanDataResourceCrudRepository.findAll().forEach(nm::add);
        return nm;
    }
}
