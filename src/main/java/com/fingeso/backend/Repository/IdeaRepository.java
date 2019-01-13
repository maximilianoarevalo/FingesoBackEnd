package com.fingeso.backend.Repository;

import com.fingeso.backend.Models.Idea;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IdeaRepository extends MongoRepository<Idea, String> {
    Idea findBy_id(ObjectId _id);
}
