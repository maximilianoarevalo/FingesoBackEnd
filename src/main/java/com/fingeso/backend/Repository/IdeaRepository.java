package com.fingeso.backend.Repository;

import com.fingeso.backend.Models.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IdeaRepository extends MongoRepository<Idea, String> {
    public Idea findIdeaById(String id);
    public List<Idea> findByNombre(String nombre);
    public List<Idea> findByNombreLike(String nombre);
    public List<Idea> findByDescripcion(String descripcion);
    public List<Idea> findByDescripcionLike(String descripcion);
    //public List<Idea> findIdeaByAutor(String id);
}
