package com.example.glow.controller;

import com.example.glow.controller.dto.LoansData;
import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.service.LoanDataResourceDataService;
import com.example.glow.service.LoansResourceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoanController {

    private LoanDataResourceDataService loanDataResourceDataService;

    @Autowired
    public LoanController(LoanDataResourceDataService loanDataResourceDataService) {
        this.loanDataResourceDataService = loanDataResourceDataService;
    }

    @GetMapping("/loan")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<LoansData> getLoansData(@RequestParam(name = "fio") String fio) {
        String customPredicate = fio.toLowerCase().trim();
        List<ApplicationsResource> coll = loanDataResourceDataService.getAll();
        List<LoansData> result = new ArrayList<>();
        for (ApplicationsResource applicationsResource: coll) {
            result.add(LoansData.builder().
                    appId(applicationsResource.getAppId())
                            .custFio(applicationsResource.getCustFio().trim())
                            .appDate(applicationsResource.getAppDate())
                    .credAmount(applicationsResource.getCredAmount())
                    .credTerm(applicationsResource.getCredTerm())
                    .credObject(applicationsResource.getCredObject().trim()).build());
        }
        List<LoansData> fio_filtrated_result= result.stream().filter(val -> val.getCustFio().toLowerCase().trim().equals(customPredicate)).collect(Collectors.toList());
        if (fio_filtrated_result.size()>0) {
            return ResponseEntity.ok(fio_filtrated_result.get(0));
        }
        return ResponseEntity.ok(null);
    }
}
