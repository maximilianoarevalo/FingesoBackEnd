package com.fingeso.backend.Repository;

import com.fingeso.backend.Models.Idea;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public interface IdeaRepository extends MongoRepository<Idea, String> {
    Idea findBy_id(ObjectId _id);
    List<Idea> findIdeaByNombre(String titulo);
}
