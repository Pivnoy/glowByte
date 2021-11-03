package com.example.glow.controller;

import com.example.glow.controller.dto.LoansData;
import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.service.LoanDataResourceDataService;
<<<<<<< HEAD
=======
import com.example.glow.service.LoansResourceDataService;
>>>>>>> d89e0f175f4666bd0df5121d7a988e3b016e233f
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Main controller for MongoDB database encapsulating all
 * get methods from multiple CRUD repositories and connecting
 * backend and local host server via mapping
 */
=======
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

>>>>>>> d89e0f175f4666bd0df5121d7a988e3b016e233f
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
<<<<<<< HEAD
            result.add(LoansData.builder()
                    .appId(applicationsResource.getAppId())
                    .custFio(applicationsResource.getCustFio().trim())
                    .appDate(applicationsResource.getAppDate())
=======
            result.add(LoansData.builder().
                    appId(applicationsResource.getAppId())
                            .custFio(applicationsResource.getCustFio().trim())
                            .appDate(applicationsResource.getAppDate())
>>>>>>> d89e0f175f4666bd0df5121d7a988e3b016e233f
                    .credAmount(applicationsResource.getCredAmount())
                    .credTerm(applicationsResource.getCredTerm())
                    .credObject(applicationsResource.getCredObject().trim()).build());
        }
        List<LoansData> fio_filtrated_result= result.stream().filter(val -> val.getCustFio().toLowerCase().trim().equals(customPredicate)).collect(Collectors.toList());
        if (fio_filtrated_result.size()>0) {
            System.out.println("Loan data request with " + fio + ", returning " + fio_filtrated_result.get(0).getAppId());
            return ResponseEntity.ok(fio_filtrated_result.get(0));
        }
        System.out.println("Loan data request with " + fio + ", returning null");
        return ResponseEntity.ok(null);
    }
}
