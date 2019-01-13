package com.fingeso.backend.Services;

import com.fingeso.backend.Models.Idea;
import com.fingeso.backend.Repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/idea")
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;
    //Muestra todas las ideas
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Idea> getAllIdea(){
        return ideaRepository.findAll();
    }
    //Busca una idea por id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Idea getIdeaById(@PathVariable String id){
        return this.ideaRepository.findIdeaById(id);
    }
    //Modificar una idea
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Idea updateIdea(@RequestBody Idea idea, @PathVariable String id){
        idea = this.ideaRepository.findIdeaById(id);
        idea.setNombre(idea.getNombre());
        idea.setDescripcion(idea.getDescripcion());
        //idea.setAutor(idea.getAutor());
        return this.ideaRepository.save(idea);
    }
    //Elimina una idea por id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteIdea(@PathVariable String id){
        Idea idea = this.ideaRepository.findIdeaById(id);
        this.ideaRepository.delete(idea);
    }
    //Crear idea ¿?
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Idea createIdea(@RequestBody Idea idea){
        Calendar today = Calendar.getInstance();
        idea.setFechaCreacion(today.getTime());
        ideaRepository.save(idea);
        return idea;
    }


}
