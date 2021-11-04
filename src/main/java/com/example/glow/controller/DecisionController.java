package com.example.glow.controller;

import com.example.glow.ml.ClientLoanApprove;
import com.example.glow.service.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DecisionController {

    private DecisionService decisionService;

    @Autowired
    public DecisionController(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @GetMapping("/decision")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<String> getDecision(@RequestParam("fio") String fio) {
        ClientLoanApprove clientLoanApprove = decisionService.getDecision(fio.trim().toLowerCase());
        return ResponseEntity.ok(clientLoanApprove.getPersonalDecision());
    }
}
