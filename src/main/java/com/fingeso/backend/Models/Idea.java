package com.fingeso.backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Document(collection = "ideas")
public class Idea {
    @Id
    private ObjectId _id;
    private String nombre;
    private String descripcion;
    @DBRef
    private List<Comentario> comentarios;
    private LocalDateTime fechaCreacion;

    public Idea(){}

    /*public Idea(ObjectId _id, String nombre, String descripcion){
        this._id = _id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.comentarios = List<Comentario>();
        this.fechaCreacion = LocalDateTime.now();
    }*/

    public String get_id(){
        return _id.toHexString();
    }
    public void set_id(ObjectId _id){
        this._id = _id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }


    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
