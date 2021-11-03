package com.example.glow.controller;

import com.example.glow.controller.dto.GuarantorBoolData;
import com.example.glow.controller.dto.GuarantorData;
import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.service.GuarantorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Main controller for MongoDB database encapsulating all
 * get methods from multiple CRUD repositories and connecting
 * backend and local host server via mapping
 */
@RestController
public class GuarantorDataController {

    private GuarantorDataService guarantorDataService;

    @Autowired
    public GuarantorDataController(GuarantorDataService guarantorDataService) {
        this.guarantorDataService = guarantorDataService;
    }

    @GetMapping("/guarantor")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<GuarantorBoolData> getGuarantorData(@RequestParam(name = "fio") String fio){
        String customPredicate = fio.toLowerCase().trim();
        List<ApplicationsResource> coll = guarantorDataService.getAll();
        List<GuarantorData> res = new ArrayList<>();
        for (ApplicationsResource applicationsResource:coll) {

            if (applicationsResource.getGuarantorBirth()==null){
                applicationsResource.setGuarantorBirth(Date.valueOf("2021-10-26"));
            }
            if (applicationsResource.getGuarantorPhone()==null){
                applicationsResource.setGuarantorPhone("Нет данных");
            }
            if (applicationsResource.getGuarantorFio()==null){
                applicationsResource.setGuarantorFio("Нет данных");
            }

            res.add(GuarantorData.builder()
                    .custFio(applicationsResource.getCustFio().trim())
                    .guarantorFio(applicationsResource.getGuarantorFio().trim())
                    .guarantorPhone(applicationsResource.getGuarantorPhone().trim())
                    .guarantorFlag(applicationsResource.getGuarantorFlag())
                    .guarantorBirth(applicationsResource.getGuarantorBirth())
                    .build());
        }
        List<GuarantorData> fio_sorted_res = res.stream().filter(val -> val.getCustFio().toLowerCase().trim().equals(customPredicate)).collect(Collectors.toList());
        if (fio_sorted_res.size()>0 && fio_sorted_res.get(0).getGuarantorFlag()){
            GuarantorBoolData guarantorBoolData;
            guarantorBoolData = GuarantorBoolData.builder()
                    .guarantorFio(fio_sorted_res.get(0).getGuarantorFio())
                    .guarantorBirth(fio_sorted_res.get(0).getGuarantorBirth())
                    .guarantorPhone(fio_sorted_res.get(0).getGuarantorPhone())
                    .custFio(fio_sorted_res.get(0).getCustFio()).build();
            System.out.println("Guarantor data request with " + fio + ", returning " + res.get(0).getGuarantorFio());
            return ResponseEntity.ok(guarantorBoolData);
        }
        System.out.println("Guarantor data request with " + fio + ", returning null");
        return ResponseEntity.ok(null);
    }
}
