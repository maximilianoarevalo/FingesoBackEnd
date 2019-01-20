package com.fingeso.backend.Services;

import com.fingeso.backend.Models.Desafio;
import com.fingeso.backend.Models.Idea;
import com.fingeso.backend.Repository.DesafioRepository;
import com.fingeso.backend.Repository.IdeaRepository;
import com.fingeso.backend.Repository.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(value = "/desafios")
public class DesafioService {
    @Autowired
    private DesafioRepository desafiorepository;
    @Autowired
    private IdeaRepository ideaRepository;
    //@Autowired
    //private UsuarioRepository usuarioRepository;


    // Crud DESAFIO
    //////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Desafio> getAllDesafio(){
        return desafiorepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public  Desafio getDesafioById(@PathVariable("id") ObjectId id){
        return  desafiorepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyDesafioById(@PathVariable("id") ObjectId id, @Valid@RequestBody Desafio desafio){
        desafio.set_id(id);
        desafiorepository.save(desafio);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Desafio createDesafio(@Valid @RequestBody Desafio desafio){
        desafio.set_id(ObjectId.get());
        desafiorepository.save(desafio);
        return desafio;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDesafio(@PathVariable ObjectId id){
        desafiorepository.delete(desafiorepository.findBy_id(id));
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    // Agrega ID Idea a Arreglo de IDeas de Desafios
    @RequestMapping(value = "/{idDesafio}/addIdea/{idIdea}", method = RequestMethod.POST)
    @ResponseBody
    public void addIdeaInsideDesafio(@PathVariable("idDesafio") ObjectId idDesafio,@PathVariable("idIdea") ObjectId idIdea ){

        Desafio desafio = this.desafiorepository.findBy_id(idDesafio);
        Idea idea = this.ideaRepository.findBy_id(idIdea);

        List<Idea> ideas = desafio.getIdeas();

        ideas.add(idea);

        this.desafiorepository.save(desafio);
    }

    // Obtener Todas las Ideas de un Desafio

    @RequestMapping(value = "/{id}/getideas", method = RequestMethod.GET)
    public List<Idea> getAllIdeasInDesafio(@PathVariable("id") ObjectId id){
        Desafio desafio = this.desafiorepository.findBy_id(id);
        return desafio.getIdeas();
    }








}
