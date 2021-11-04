package com.example.glow.service;

import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.ml.ClientForm;
import com.example.glow.ml.ClientLoanApprove;
import com.example.glow.ml.chooserimpl.ChooserXGBoost;
import com.example.glow.repository.postgreSqlRep.LoanDataResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DecisionService {

    private LoanDataResourceCrudRepository loanDataResourceCrudRepository;
    private ChooserXGBoost chooserXGBoost;
    private ClientForm clientForm;


    @Autowired
    public DecisionService(LoanDataResourceCrudRepository loanDataResourceCrudRepository, ChooserXGBoost chooserXGBoost) {
        this.loanDataResourceCrudRepository = loanDataResourceCrudRepository;
        this.chooserXGBoost = chooserXGBoost;
    }

    public ClientLoanApprove getDecision(String fio) {
        List<ApplicationsResource> res = new ArrayList<>();
        loanDataResourceCrudRepository.findAll().forEach(res::add);
        for (ApplicationsResource applicationsResource:res){
            if (applicationsResource.getCustFio().toLowerCase(Locale.ROOT).trim().equals(fio)){
                clientForm = ClientForm.builder()
                        .custFio(applicationsResource.getCustFio())
                        .custId(applicationsResource.getCustId())
                        .custInn(applicationsResource.getCustInn())
                        .appSaleChannel(applicationsResource.getAppSaleChannel())
                        .credAmount(applicationsResource.getCredAmount())
                        .custFamilyMonthIncome(applicationsResource.getCustFamilyMonthIncome())
                        .custRelationBankType(applicationsResource.getCustRelationBankType())
                        .build();
                return chooserXGBoost.chooseForClient(clientForm);
            }
        }
        return null;
    }

}
