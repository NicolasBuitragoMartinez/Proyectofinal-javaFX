package co.edu.uniquindio.marketplace.marketplaceapp.model;

import co.edu.uniquindio.marketplace.marketplaceapp.model.builder.PublicacionBuilder;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private int like;
    public List<Comentario> comentarios;
    public Producto producto;
    public Publicacion(int like, Producto producto, List<Comentario> comentarios){
        this.like = like;
        this.comentarios = new ArrayList<>();
        this.producto = producto;
    }
    public Publicacion(){}
    public static PublicacionBuilder builder(){return new PublicacionBuilder();}
    public int getLike(){return like;}
    public List<Comentario> getComentarios(){return comentarios;}
    public Producto getProducto(){return producto;}
    public void setLike(int like){
        this.like = like;
    }
    public void setComentarios(List<Comentario> comentarios){
        this.comentarios = comentarios;
    }
    public void setProducto(Producto producto){this.producto = producto;}
    public void darMeGusta() {this.like++;}
    public int obtenerMeGusta() {return this.like;}
    public void agregarComentario(Comentario comentario) {
        if (comentario != null) {
            this.comentarios.add(comentario);
        }
    }
}
