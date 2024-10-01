package co.edu.uniquindio.marketplace.marketplaceapp.model;

import co.edu.uniquindio.marketplace.marketplaceapp.model.builder.VendedorBuilder;

import java.util.List;
import java.util.ArrayList;

public class Vendedor extends Persona{
    private Muro muro;
    private List<Vendedor> vendedoresAliados;
    private List<Producto> productosAgregados;
    public Vendedor(String nombre,
                    String apellido,
                    String cedula,
                    String direccion,
                    Usuario usuario){
        super(nombre, apellido, cedula, direccion, usuario);
        this.muro = new Muro();
        this.vendedoresAliados = new ArrayList<>();
        this.productosAgregados = new ArrayList<>();
    }
    public Vendedor(){
        this.muro = new Muro();
        this.vendedoresAliados = new ArrayList<>();
        this.productosAgregados = new ArrayList<>();
    }
    public static VendedorBuilder builder(){return new VendedorBuilder();}
    public Muro getMuro(){return muro;}
    public List<Vendedor> getVendedoresAliados(){return vendedoresAliados;}
    public List<Producto> getProductosAgregados(){return productosAgregados;}
    public void setMuro(Muro muro){
        this.muro = muro;
    }
    public void setVendedoresAliados(List<Vendedor> vendedoresAliados){
        this.vendedoresAliados = vendedoresAliados;
    }
    public void setProductosAgregados(List<Producto> productosAgregados){
        this.productosAgregados = productosAgregados;
    }
    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion +
                '}';
    }
}
