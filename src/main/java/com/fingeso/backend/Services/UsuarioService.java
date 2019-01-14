package com.fingeso.backend.Services;

import com.fingeso.backend.Models.Usuario;
import com.fingeso.backend.Repository.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioService {
  @Autowired
  private UsuarioRepository repository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Usuario> getAllUsuario(){
      return repository.findAll();
  }
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Usuario getUsuarioById(@PathVariable("id") ObjectId id){
      return repository.findBy_id(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyUsuarioById(@PathVariable("id") ObjectId id, @Valid@RequestBody Usuario usuario){
      usuario.set_id(id);
      repository.save(usuario);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Usuario createUsuario(@Valid @RequestBody Usuario usuario){
      usuario.set_id(ObjectId.get());
      repository.save(usuario);
      return usuario;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteUsuario(@PathVariable ObjectId id){
      repository.delete(repository.findBy_id(id));
  }
}
