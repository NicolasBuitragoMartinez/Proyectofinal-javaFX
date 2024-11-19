package co.edu.uniquindio.marketplace.marketplaceapp.patrones.builder;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Publicacion;

public class PublicacionBuilder {
    protected int like;
    protected Producto producto;
    protected List<Comentario> comentarios;
    public PublicacionBuilder like(int like){
        this.like = like;
        return this;
    }
    public PublicacionBuilder producto(Producto producto){
        this.producto = producto;
        return this;
    }
    public PublicacionBuilder comentarios(List<Comentario> comentarios){
        this.comentarios = comentarios;
        return this;
    }
    public Publicacion build(){
        return new Publicacion(like, producto, comentarios);
    }
}
