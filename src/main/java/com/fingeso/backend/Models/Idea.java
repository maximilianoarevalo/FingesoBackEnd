package com.fingeso.backend.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Idea {
    @Id
    private ObjectId _id;
    private String nombre;
    private String descripcion;

    public Idea(){}

    public Idea(ObjectId _id, String nombre, String descirpcion){
        this._id = _id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
