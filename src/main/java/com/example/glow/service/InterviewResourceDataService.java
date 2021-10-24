package com.example.glow.service;

import com.example.glow.entity.mongoDb.InterviewResource;
import com.example.glow.repository.mongoDbRep.InterviewResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewResourceDataService {

    private InterviewResourceRepository interviewResourceRepository;

    @Autowired
    public InterviewResourceDataService(InterviewResourceRepository interviewResourceRepository) {
        this.interviewResourceRepository = interviewResourceRepository;
    }


    public List<InterviewResource>  getAllOutputData(){
        return interviewResourceRepository.findAll();
    }
}
