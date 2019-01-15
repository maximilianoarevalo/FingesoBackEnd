package com.fingeso.backend.Repository;

import com.fingeso.backend.Models.Desafio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DesafioRepository extends MongoRepository<Desafio, String> {
    Desafio findBy_id(Object _id);
}
