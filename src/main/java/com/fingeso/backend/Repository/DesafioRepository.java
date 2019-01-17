package com.fingeso.backend.Repository;

import com.fingeso.backend.Models.Desafio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public interface DesafioRepository extends MongoRepository<Desafio, String> {
    Desafio findBy_id(Object _id);
}



