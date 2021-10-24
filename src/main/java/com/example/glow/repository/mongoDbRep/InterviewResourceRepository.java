package com.example.glow.repository.mongoDbRep;

import com.example.glow.entity.mongoDb.InterviewResource;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Implements methods of CRUD repository to connect to mongoDB database
 * and to get all Interview collections
 */

public interface InterviewResourceRepository extends MongoRepository<InterviewResource, Long> {


}