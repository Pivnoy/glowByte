package com.example.glow.controller;

import com.example.glow.entity.postgreSql.LoansResource;
import com.example.glow.service.LoansResourceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    private LoansResourceDataService loansResourceDataService;

    @Autowired
    public PostController(LoansResourceDataService loansResourceDataService) {
        this.loansResourceDataService = loansResourceDataService;
    }

    @GetMapping("/post")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<List<LoansResource>> getAnswer() {
        return ResponseEntity.ok(loansResourceDataService.getAllOutputData());
    }
}
