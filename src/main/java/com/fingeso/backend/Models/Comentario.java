package com.fingeso.backend.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;


import java.time.LocalDateTime;
import java.util.Date;

public class Comentario {

        @Id
        private ObjectId _id;
        //private Usuario autor;
        private String autor;
        //@DBRef
        private String comentario;
        private LocalDateTime fechaCreacion;


        public Comentario(){}

        public Comentario(ObjectId _id, String autor, String comentario){
                this._id = _id;
                this.autor = autor;
                this.comentario = comentario;
                this.fechaCreacion = LocalDateTime.now();
        }

        public String get_id(){
                return _id.toHexString();
        }
        public void set_id(ObjectId _id){
                this._id = _id;
        }
        public String getautor(){
                return autor;
        }
        public void setautor(String autor){
                this.autor = autor;
        }
        public String getcomentario(){
                return comentario;
        }
        public void setcomentario(String comentario){
                this.comentario = comentario;
        }

}
