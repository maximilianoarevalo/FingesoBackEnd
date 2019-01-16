package com.fingeso.backend.Services;

import com.fingeso.backend.Models.Comentario;
import com.fingeso.backend.Repository.ComentarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(value = "/comentarios")

public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;



    // CRUD
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Comentario> getAllComentario(){
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Comentario getComentarioById(@PathVariable("id") ObjectId id){
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyComentarioById(@PathVariable("id") ObjectId id, @Valid @RequestBody Comentario comentario){
        comentario.set_id(id);
        repository.save(comentario);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Comentario createComentario(@Valid @RequestBody Comentario comentario){
        comentario.set_id(ObjectId.get());
        repository.save(comentario);
        return comentario;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteComentario(@PathVariable ObjectId id){
        repository.delete(repository.findBy_id(id));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////



















}
