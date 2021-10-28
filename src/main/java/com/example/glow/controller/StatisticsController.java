package com.example.glow.controller;

import com.example.glow.controller.dto.StatisticsData;
import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.service.GuarantorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Main controller for MongoDB database encapsulating all
 * get methods from multiple CRUD repositories and connecting
 * backend and local host server via mapping
 */
@RestController
public class StatisticsController {

    private GuarantorDataService guarantorDataService;

    @Autowired

    public StatisticsController(GuarantorDataService guarantorDataService) {
        this.guarantorDataService = guarantorDataService;
    }

    @GetMapping("/statistics")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<StatisticsData> getStatisticsData(){
        List<ApplicationsResource> coll = guarantorDataService.getAll();
        StatisticsData statisticsData;
        Integer clientNumber = coll.size();
        Double creditSum = 0.0;
        Integer guarantorSum = 0;
        Double income = 0.0;
        for (ApplicationsResource applicationsResource:coll){
            creditSum+=applicationsResource.getCredAmount();
            if (applicationsResource.getGuarantorFlag()){
                guarantorSum++;
            }
            if (applicationsResource.getCustMonthIncome()!=null)
                income+=applicationsResource.getCustMonthIncome();
        }
        income=income/clientNumber;
        Double guarantPercent = ((guarantorSum * 1.0)/clientNumber) * 100.0;
        statisticsData = StatisticsData.builder()
                .guarantorPercent(guarantPercent)
                .middleIncome(income)
                .clientNumber(clientNumber)
                .creditSum(creditSum)
                .build();
        return ResponseEntity.ok(statisticsData);
    }
}
