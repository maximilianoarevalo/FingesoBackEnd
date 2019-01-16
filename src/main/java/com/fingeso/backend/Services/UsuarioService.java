package com.fingeso.backend.Services;

import com.fingeso.backend.Models.Usuario;
import com.fingeso.backend.Models.Idea;
import com.fingeso.backend.Repository.UsuarioRepository;
import com.fingeso.backend.Repository.IdeaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioService {
  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private IdeaRepository ideaRepository;
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Usuario> getAllUsuario(){
      return usuarioRepository.findAll();
  }
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Usuario getUsuarioById(@PathVariable("id") ObjectId id){
      return usuarioRepository.findBy_id(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyUsuarioById(@PathVariable("id") ObjectId id, @Valid @RequestBody Usuario usuario){
      usuario.set_id(id);
      usuarioRepository.save(usuario);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Usuario createUsuario(@Valid @RequestBody Usuario usuario){
      usuario.set_id(ObjectId.get());
      usuarioRepository.save(usuario);
      return usuario;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public Idea createIdeaByUsuario(@PathVariable("id") ObjectId id,@Valid @RequestBody Idea idea){
      ObjectId ideaId=ObjectId.get();
      idea.set_id(ideaId);
      ideaRepository.save(idea);
      Usuario usuario=usuarioRepository.findBy_id(id);
      usuario.crearIdea(ideaId);
      usuarioRepository.save(usuario);
      return idea;
  }
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteUsuario(@PathVariable ObjectId id){
      usuarioRepository.delete(usuarioRepository.findBy_id(id));
  }
}
