package co.edu.uniquindio.marketplace.marketplaceapp.model;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private int like;
    private List<Comentario> comentarios;
    public Publicacion(int like){
        this.like = like;
        this.comentarios = new ArrayList<>();
    }
    public Publicacion(){}
    public int getLike(){return like;}
    public List<Comentario> getComentarios(){return comentarios;}
    public void setLike(int like){
        this.like = like;
    }
    public void setComentarios(List<Comentario> comentarios){
        this.comentarios = comentarios;
    }
    public void darMeGusta() {this.like++;}
    public int obtenerMeGusta() {return this.like;}
}
