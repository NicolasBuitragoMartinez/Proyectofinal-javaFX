package co.edu.uniquindio.marketplace.marketplaceapp.model.builder;

import co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Publicacion;
import javafx.scene.image.Image;

public class ProductoBuilder {
    protected Publicacion publicacion;
    protected String nombre;
    protected String identificador;
    protected Image imagen;
    protected String categoria;
    protected int precio;
    protected EstadoProducto estado;
    public ProductoBuilder publicacion(Publicacion publicacion){
        this.publicacion = publicacion;
        return this;
    }
    public ProductoBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public ProductoBuilder identificador(String identificador){
        this.identificador = identificador;
        return this;
    }
    public ProductoBuilder imagen(Image imagen){
        this.imagen = imagen;
        return this;
    }
    public ProductoBuilder categoria(String categoria){
        this.categoria = categoria;
        return this;
    }
    public ProductoBuilder precio(int precio){
        this.precio = precio;
        return this;
    }
    public ProductoBuilder estado(EstadoProducto estado){
        this.estado = estado;
        return this;
    }
    public Producto build(){
        return new Producto(nombre,
                identificador,
                imagen,
                categoria,
                precio,
                estado);
    }
}