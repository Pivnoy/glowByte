package com.example.glow.controller;

import com.example.glow.entity.mySql.ClientResource;
import com.example.glow.service.ClientResourceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BasicController {

    private ClientResourceDataService clientResourceDataService;

    @Autowired
    public BasicController(ClientResourceDataService clientResourceDataService) {
        this.clientResourceDataService = clientResourceDataService;
    }

    @GetMapping("/mysql")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<List<ClientResource>> basicReq() {
        return ResponseEntity.ok(clientResourceDataService.getAllOutputData());
    }
}
