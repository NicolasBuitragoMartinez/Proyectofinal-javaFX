package co.edu.uniquindio.marketplace.marketplaceapp.model;

import co.edu.uniquindio.marketplace.marketplaceapp.model.builder.ComentarioBuilder;

public class Comentario {
    private String comentario;
    public Comentario(String comentario){
        this.comentario = comentario;
    }
    public Comentario(){}
    public static ComentarioBuilder builder( ){return new ComentarioBuilder();}
    public String getComentario(){return comentario;}
    public void setComentario(String comentario){
        this.comentario = comentario;
    }
}
