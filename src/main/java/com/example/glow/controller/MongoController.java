package com.example.glow.controller;

import com.example.glow.entity.mongoDb.InterviewResource;
import com.example.glow.service.InterviewResourceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MongoController {

    private InterviewResourceDataService interviewResourceDataService;

    @Autowired
    public MongoController(InterviewResourceDataService interviewResourceDataService) {
        this.interviewResourceDataService = interviewResourceDataService;
    }

    @GetMapping("/mongo")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<List<InterviewResource>> getAl() {
        return ResponseEntity.ok(interviewResourceDataService.getAllOutputData());
    }
}
