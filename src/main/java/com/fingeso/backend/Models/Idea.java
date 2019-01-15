package com.fingeso.backend.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

//@Document(collection = "ideas")
public class Idea {
    @Id
    private ObjectId _id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;

    public Idea(){}

    public Idea(ObjectId _id, String nombre, String descripcion){
        this._id = _id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDateTime.now();
    }

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


}
