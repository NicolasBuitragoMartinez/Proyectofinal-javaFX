package co.edu.uniquindio.marketplace.marketplaceapp.model;

public class Comentario {
    private String comentario;
    public Comentario(String comentario){
        this.comentario = comentario;
    }
    public Comentario(){}
    public String getComentario(){return comentario;}
    public void setComentario(String comentario){
        this.comentario = comentario;
    }
}
