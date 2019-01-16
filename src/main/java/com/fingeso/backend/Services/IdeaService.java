package com.fingeso.backend.Services;

import com.fingeso.backend.Models.Comentario;
import com.fingeso.backend.Models.Desafio;
import com.fingeso.backend.Models.Idea;
import com.fingeso.backend.Repository.ComentarioRepository;
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
    private IdeaRepository ideaRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;


    //CRUD  IDEa
    //////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Idea> getAllIdea(){
        return ideaRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Idea getIdeaById(@PathVariable("id") ObjectId id){
        return ideaRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyIdeaById(@PathVariable("id") ObjectId id, @Valid@RequestBody Idea idea){
        idea.set_id(id);
        ideaRepository.save(idea);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Idea createIdea(@Valid @RequestBody Idea idea){
        idea.set_id(ObjectId.get());
        ideaRepository.save(idea);
        return idea;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteIdea(@PathVariable ObjectId id){
        ideaRepository.delete(ideaRepository.findBy_id(id));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Agrega ID comentario a Arreglo de comentarios de Idea
    @RequestMapping(value = "/{idIdea}/addComentario/{idComentario}", method = RequestMethod.POST)
    @ResponseBody
    public void addcomentarioInsideIdea(@PathVariable("idIdea") ObjectId idIdea,@PathVariable("idComentario") ObjectId idComentario ){

        Idea idea = this.ideaRepository.findBy_id(idIdea);
        Comentario comentario = this.comentarioRepository.findBy_id(idComentario);
        List<Comentario> Comentarios = idea.getComentarios();

        Comentarios.add(comentario);
        this.ideaRepository.save(idea);
    }












}
