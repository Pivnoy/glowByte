package com.example.glow.service;

import com.example.glow.entity.mongoDb.InterviewResource;
import com.example.glow.repository.mongoDbRep.InterviewResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewResourceDataService {

    private InterviewResourceCrudRepository interviewResourceCrudRepository;

    @Autowired
    public InterviewResourceDataService(InterviewResourceCrudRepository interviewResourceCrudRepository) {
        this.interviewResourceCrudRepository = interviewResourceCrudRepository;
    }

    public List<InterviewResource>  getAllOutputData(){
        return interviewResourceCrudRepository.findAll();
    }
}
