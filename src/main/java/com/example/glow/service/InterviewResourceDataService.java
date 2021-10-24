package com.example.glow.service;

import com.example.glow.entity.mongoDb.InterviewResource;
import com.example.glow.repository.mongoDbRep.InterviewResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 */
@Service
public class InterviewResourceDataService {

    private InterviewResourceRepository interviewResourceRepository;

    @Autowired
    public InterviewResourceDataService(InterviewResourceRepository interviewResourceRepository) {
        this.interviewResourceRepository = interviewResourceRepository;
    }

    /**
     * Gets all string dialog hashes from mongoDB
     * @return Json-format file of <String,String> dialog maps from database
     */
    public List<InterviewResource>  getAllOutputData(){
        return interviewResourceRepository.findAll();
    }
}
