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

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Main controller for mySql database encapsulating all
 * get methods from multiple CRUD repositories and connecting
 * backend and local host server via mapping
 */
@RestController
public class MySqlController {

    private ClientResourceDataService clientResourceDataService;

    @Autowired
    public MySqlController(ClientResourceDataService clientResourceDataService) {
        this.clientResourceDataService = clientResourceDataService;
    }

    /**
     * Get data from services and pack it in a form for response to front-end
     * @return list of all crucial data from mySql database
     */
    @GetMapping("/mysql")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<List<ClientResource>> basicReq() {
        return ResponseEntity.ok(clientResourceDataService.getAllOutputData());
    }
}
