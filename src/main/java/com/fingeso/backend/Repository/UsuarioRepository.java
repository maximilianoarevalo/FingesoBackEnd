package com.fingeso.backend.Repository;

import com.fingeso.backend.Models.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findBy_id(ObjectId _id);
}
