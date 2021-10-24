package com.example.glow.repository.mongoDbRep;

import com.example.glow.entity.mongoDb.InterviewResource;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;



public interface InterviewResourceRepository extends MongoRepository<InterviewResource, String> {


}