package com.fingeso.backend.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Idea {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fechaCreacion;

    /*@DBRef
    private Usuario autor;

    @DBRef
    private List<Comentario> comentarios;*/

    public String getId(){
        return id;
    }

    public void setId(String _id){
        this.id = id;
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

    public Date getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

   /*public Usuario getAutor(){
        return autor;
    }

    public void setAutor(Usuario autor){
        this.autor = autor;
    }

    public List<Comentario> getComentarios(){
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios){
        this.comentarios = comentarios;
    }*/

}
