package com.fingeso.backend.Models;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Usuario {
    @Id
    private ObjectId _id;
    private String Nombres;
    private String Apellidos;
    private Date fechaNacimiento;
    private String email;
    private List<ObjectId> listaIdeas;

    public Usuario(ObjectId _id, String Nombres, String Apellidos,Date fechaNacimiento,String email){
        this._id = _id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.fechaNacimiento=fechaNacimiento;
        this.email=email;
        this.listaIdeas=new ArrayList<ObjectId>();
    }
    public String get_id(){
        return _id.toHexString();
    }
    public void set_id(ObjectId _id){
        this._id = _id;
    }
    public String getNombres(){
        return Nombres;
    }
    public void setNombres(String nombre){
        this.Nombres = Nombres;
    }
    public String getApellidos(){
      return Apellidos;
    }
    public void setApellidos(String apellidos){
      this.Apellidos= Apellidos;
    }
    public Date getFechaNacimiento(){
      return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento){
      this.fechaNacimiento=fechaNacimiento;
    }
    public String getEmail(){
      return email;
    }
    public void setEmail(String email){
      this.email=email;
    }
    public List<ObjectId> getListaIdeas(){
      return listaIdeas;
    }
    public void setListaIdeas(List<ObjectId> listaIdeas){
      this.listaIdeas=listaIdeas;
    }
    public void crearIdea(ObjectId ideaId){
      listaIdeas.add(ideaId);
    }

    public void editarIdea(){

    }

    public void crearComentario(){

    }

    public void editarComentario(){

    }

    public void crearDesafio(){

    }

    public void editarDesafio(){

    }


    public void buscarComentario(){

    }

    public void buscarIdea(){

    }











}
