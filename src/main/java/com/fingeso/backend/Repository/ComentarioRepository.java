package com.fingeso.backend.Repository;

import com.fingeso.backend.Models.Comentario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ComentarioRepository extends MongoRepository<Comentario, String> {
    Comentario findBy_id(ObjectId _id);
}
