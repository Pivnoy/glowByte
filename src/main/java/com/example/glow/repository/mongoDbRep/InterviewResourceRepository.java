package com.example.glow.repository.mongoDbRep;

import com.example.glow.entity.mongoDb.InterviewResource;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface InterviewResourceRepository extends MongoRepository<InterviewResource, Long> {


}