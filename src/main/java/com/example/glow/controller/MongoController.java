package com.example.glow.controller;

import com.example.glow.entity.mongoDb.InterviewResource;
import com.example.glow.entity.postgreSql.ApplicationsResource;
import com.example.glow.service.InterviewResourceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

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
    @GetMapping("/interview")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<InterviewResource> getAl(@RequestParam(name = "fio") String fio) {
        List<InterviewResource> nm = new ArrayList<>(interviewResourceDataService.getAllOutputData());
        final Integer wordsFromNameMatch = 4;
        final Integer fioLength = 3;
        fio = fio.toLowerCase(Locale.ROOT).trim();
        Pattern patternMatchWords = Pattern.compile(" ");
        String[] matchedFio = patternMatchWords.split(fio);
        StringBuilder matchingNameString = new StringBuilder();
        for (Integer i = 0;i<fioLength;i++){
            matchingNameString.append(matchedFio[i], 0, wordsFromNameMatch).append(" ");
        }
        String normalName;
        for (InterviewResource interviewResource:nm){
            normalName = interviewResource.getAnswersOnQuestions().get("I1").toLowerCase().trim();
            String[] matchedName = patternMatchWords.split(normalName);
            StringBuilder matchingNormalName = new StringBuilder();
            Integer index = matchedName.length - fioLength;
            for (Integer i = index;i < matchedName.length;i++){
                matchingNormalName.append(matchedName[i],0,wordsFromNameMatch).append(" ");
            }
            if (matchingNormalName.toString().equals(matchingNameString.toString())){
                System.out.println("Interview request with " + fio + ", returning " + interviewResource.getId());
                return ResponseEntity.ok(interviewResource);
            }
        }
        System.out.println("Interview request with " + fio + ", returning null");
        return ResponseEntity.ok(null);
    }
}
