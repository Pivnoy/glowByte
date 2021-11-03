package com.example.glow.service;

import com.example.glow.controller.dto.IncomeData;
import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.entity.postgreSql.ClientsResource;
import com.example.glow.entity.postgreSql.LoanBalanceResource;
import com.example.glow.entity.postgreSql.LoansResource;
import com.example.glow.repository.postgreSqlRep.ClientsResourceCrudRepository;
import com.example.glow.repository.postgreSqlRep.LoanBalanceResourceCrudRepository;
import com.example.glow.repository.postgreSqlRep.LoanDataResourceCrudRepository;
import com.example.glow.repository.postgreSqlRep.LoansResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class IncomeService {

    private LoanDataResourceCrudRepository loanDataResourceCrudRepository;
    private LoanBalanceResourceCrudRepository loanBalanceResourceCrudRepository;
    private ClientsResourceCrudRepository clientsResourceCrudRepository;
    private LoansResourceCrudRepository loansResourceCrudRepository;

    @Autowired
    public IncomeService(LoanDataResourceCrudRepository loanDataResourceCrudRepository, LoanBalanceResourceCrudRepository loanBalanceResourceCrudRepository, ClientsResourceCrudRepository clientsResourceCrudRepository, LoansResourceCrudRepository loansResourceCrudRepository) {
        this.loanDataResourceCrudRepository = loanDataResourceCrudRepository;
        this.loanBalanceResourceCrudRepository = loanBalanceResourceCrudRepository;
        this.clientsResourceCrudRepository = clientsResourceCrudRepository;
        this.loansResourceCrudRepository = loansResourceCrudRepository;
    }
<<<<<<< HEAD
    /**
     * Calculate multiple data from different mySql tables,
     * and combine them together
     * @return list of calculated information for bank
     */
=======

>>>>>>> d89e0f175f4666bd0df5121d7a988e3b016e233f
    public List<IncomeData> getIncomeData() {
        List<ApplicationsResource> resources = new ArrayList<>();
        List<LoanBalanceResource> loansResources = new ArrayList<>();
        List<LoansResource> govno = new ArrayList<>();
        List<ClientsResource> client = new ArrayList<>();
        loanDataResourceCrudRepository.findAll().forEach(resources::add);
        loanBalanceResourceCrudRepository.findAll().forEach(loansResources::add);
        clientsResourceCrudRepository.findAll().forEach(client::add);
        loansResourceCrudRepository.findAll().forEach(govno::add);
        Map<Long, Integer> integerMap = new HashMap<>();
        for (LoanBalanceResource loansResource: loansResources) {
            int count = integerMap.getOrDefault(loansResource.getLoanId(), 0);
            integerMap.put(loansResource.getLoanId(), count + 1);
        }
        Map<Long, Integer> inter = new HashMap<>();
        for (LoansResource loansResource : govno) {
            inter.put(loansResource.getClientId(), integerMap.get(loansResource.getLoanId()));
        }
        Map<String, Integer> res = new HashMap<>();
        for (ClientsResource clientResource: client) {
            int value = inter.get(clientResource.getClientId());
            res.put(clientResource.getFio(),value);
        }
        List<IncomeData> data = new ArrayList<>();

        Map<Long, Double> sum = new HashMap<>();
        for (LoanBalanceResource loansResource: loansResources) {
            Double count = sum.getOrDefault(loansResource.getLoanId(), 0.0);
            sum.put(loansResource.getLoanId(), count + loansResource.getOdAmt());
        }
        Map<Long, Double> connectSum = new HashMap<>();
        for (LoansResource loansResource : govno) {
            connectSum.put(loansResource.getClientId(), sum.get(loansResource.getLoanId()));
        }
        Map<String, Double> resSum = new HashMap<>();
        for (ClientsResource clientResource: client) {
            Double value = connectSum.get(clientResource.getClientId());
            resSum.put(clientResource.getFio(),value);
        }
        for (ApplicationsResource applicationsResource: resources) {
            data.add(IncomeData.builder()
                    .custMonthIncome(applicationsResource.getCustMonthIncome())
                    .custFamilyMonthIncome(applicationsResource.getCustFamilyMonthIncome())
                    .creditsCounts(res.get(applicationsResource.getCustFio()))
                    .creditSum(resSum.get(applicationsResource.getCustFio()))
                    .custFio(applicationsResource.getCustFio()).build());
        }
        return data;
    }
}
