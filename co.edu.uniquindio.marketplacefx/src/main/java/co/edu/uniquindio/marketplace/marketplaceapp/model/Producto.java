package co.edu.uniquindio.marketplace.marketplaceapp.model;

import co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.builder.ProductoBuilder;
import javafx.scene.image.Image;

public abstract class Producto {
    private Publicacion publicacion;
    private String nombre;
    private String identificador;
    private Image imagen;
    private String categoria;
    private int precio;
    private EstadoProducto estado;
    public Producto(String nombre,
                    String identificador,
                    Image imagen,
                    String categoria,
                    int precio,
                    EstadoProducto estado){
        this.publicacion = new Publicacion();
        this.nombre = nombre;
        this.identificador = identificador;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }
    public Producto(){}

    public Producto(String nombre, String categoria, int precio, EstadoProducto estado,
                    Object idProducto) {
    }

    public static ProductoBuilder builder(){return new ProductoBuilder();}
    public Publicacion getPublicacion(){return publicacion;}
    public String getNombre(){return nombre;}
    public String getIdentificador(){return identificador;}
    public Image getImagen(){return imagen;}
    public String getCategoria(){return categoria;}

    public abstract String getDetalles();

    public int getPrecio(){return precio;}
    public EstadoProducto getEstado(){return estado;}
    public void setPublicacion(Publicacion publicacion){this.publicacion = publicacion;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setIdentificador(String identificador){this.identificador = identificador;}
    public void setImagen(Image imagen){this.imagen = imagen;}
    public void setCategoria(String categoria){this.categoria = categoria;}
    public void setPrecio(int precio){this.precio = precio;}
    public void setEstado(EstadoProducto estado){this.estado = estado;}
    @Override
    public String toString() {
        return "Producto{" +
                ", nombre='" + nombre + '\'' +
                ", identificador=' " + identificador + '\'' +
                ", imagen=" + (imagen != null ? imagen.getUrl() : "null") +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                '}';
    }

    public Object getIdProducto() {
        return null;
    }

    public Object getDescripcion() {
        return null;
    }
}
