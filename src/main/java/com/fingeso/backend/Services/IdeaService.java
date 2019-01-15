package com.fingeso.backend.Services;

import com.fingeso.backend.Models.Idea;
import com.fingeso.backend.Repository.IdeaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(value = "/ideas")
public class IdeaService {
    @Autowired
    private IdeaRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Idea> getAllIdea(){
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Idea getIdeaById(@PathVariable("id") ObjectId id){
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyIdeaById(@PathVariable("id") ObjectId id, @Valid@RequestBody Idea idea){
        idea.set_id(id);
        repository.save(idea);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Idea createIdea(@Valid @RequestBody Idea idea){
        idea.set_id(ObjectId.get());
        repository.save(idea);
        return idea;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteIdea(@PathVariable ObjectId id){
        repository.delete(repository.findBy_id(id));
    }


}
