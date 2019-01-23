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

import static ch.qos.logback.core.joran.action.ActionConst.NULL;

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

    @RequestMapping(value = "/{id}/comentarios", method = RequestMethod.GET)
    public List<Comentario> getAllComentarioInIdea(@PathVariable("id") ObjectId id){
        Idea idea = this.ideaRepository.findBy_id(id);
        return idea.getComentarios();
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
    @RequestMapping(value = "/{id}/addComentario", method = RequestMethod.POST)
    @ResponseBody
    public void addcomentarioInsideIdea(@PathVariable("id") ObjectId id,@Valid @RequestBody Comentario comentario ){
      comentario.set_id(ObjectId.get());
        System.out.println(comentario.getcomentario());
      Comentario comentario1 = this.comentarioRepository.save(comentario);
      Idea idea = this.ideaRepository.findBy_id(id);
      List<Comentario> Comentarios = idea.getComentarios();
      idea.agregarComentario(comentario1);
      this.ideaRepository.save(idea);
    }

    // Buscar Idea por Titulo
    @RequestMapping(value = "/buscar/{String}", method = RequestMethod.GET)
    @ResponseBody
    public List<Idea> buscarIdeaPorTitulo(@PathVariable("String") String titulo ){


        /*if(titulo.equals("a")){
            return this.ideaRepository.findAll();
        }*/
        return this.ideaRepository.findIdeaByNombre(titulo);
    }

    








}
