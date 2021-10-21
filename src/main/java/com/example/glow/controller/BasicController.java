package com.example.glow.controller;

import com.example.glow.entity.ClientResource;
import com.example.glow.service.ClientResourceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasicController {

    private ClientResourceDataService clientResourceDataService;

    @Autowired
    public BasicController(ClientResourceDataService clientResourceDataService) {
        this.clientResourceDataService = clientResourceDataService;
    }

    @GetMapping("/")
    @ResponseBody
    public String basicReq() {
        List<ClientResource> mt = clientResourceDataService.getAllOutputData();
        return mt.get(0).getClientID().toString();
    }
}
