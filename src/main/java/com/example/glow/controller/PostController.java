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

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Main controller for postgreSql database encapsulating all
 * get methods from multiple CRUD repositories and connecting
 * backend and local host server via mapping
 */
@RestController
public class PostController {

    private LoansResourceDataService loansResourceDataService;

    @Autowired
    public PostController(LoansResourceDataService loansResourceDataService) {
        this.loansResourceDataService = loansResourceDataService;
    }

    /**
     * Get data from services and pack it in a form for response to front-end
     * @return list of all crucial data from postgreSql database
     */
    @GetMapping("/post")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<List<LoansResource>> getAnswer() {
        return ResponseEntity.ok(loansResourceDataService.getAllOutputData());
    }
}
