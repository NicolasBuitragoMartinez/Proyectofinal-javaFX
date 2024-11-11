package co.edu.uniquindio.marketplace.marketplaceapp.model.builder;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Comentario;

public class ComentarioBuilder {
    protected String comentario;
    public ComentarioBuilder comentario(String comentario){
        this.comentario = comentario;
        return this;
    }
    public Comentario build(){
        return new Comentario(comentario);
    }
}
