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

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Main controller for MongoDB database encapsulating all
 * get methods from multiple CRUD repositories and connecting
 * backend and local host server via mapping
 */
@RestController
public class MongoController {

    private InterviewResourceDataService interviewResourceDataService;

    @Autowired
    public MongoController(InterviewResourceDataService interviewResourceDataService) {
        this.interviewResourceDataService = interviewResourceDataService;
    }

    /**
     * Get data from services and pack it in a Json-form for response to front-end
     * @return list of all crucial data from MongoDB database
     */
    @GetMapping("/mongo")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<List<InterviewResource>> getAl() {
        return ResponseEntity.ok(interviewResourceDataService.getAllOutputData());
    }
}
