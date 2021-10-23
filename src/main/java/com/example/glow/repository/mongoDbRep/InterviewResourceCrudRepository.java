package com.example.glow.repository.mongoDbRep;

import com.example.glow.entity.mongoDb.InterviewResource;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface InterviewResourceCrudRepository extends MongoRepository<InterviewResource, String>{

    @Override
    List<InterviewResource> findAll();
}
