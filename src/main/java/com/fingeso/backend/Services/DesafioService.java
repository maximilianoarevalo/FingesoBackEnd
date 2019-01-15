package com.fingeso.backend.Services;

import com.fingeso.backend.Models.Desafio;
import com.fingeso.backend.Repository.DesafioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/desafios")
public class DesafioService {
    @Autowired
    private DesafioRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Desafio> getAllDesafio(){
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public  Desafio getDesafioById(@PathVariable("id") ObjectId id){
        return  repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyDesafioById(@PathVariable("id") ObjectId id, @Valid@RequestBody Desafio desafio){
        desafio.set_id(id);
        repository.save(desafio);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Desafio createDesafio(@Valid @RequestBody Desafio desafio){
        desafio.set_id(ObjectId.get());
        repository.save(desafio);
        return desafio;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDesafio(@PathVariable ObjectId id){
        repository.delete(repository.findBy_id(id));
    }
}
