package co.edu.uniquindio.marketplace.marketplaceapp.model;

import co.edu.uniquindio.marketplace.marketplaceapp.patrones.builder.VendedorBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Vendedor extends Persona{
    private Muro muro;
    private List<Vendedor> vendedoresAliados;
    private Set<Vendedor> aliados = new HashSet<>();
    private List<Producto> productosAgregados;

    public Vendedor(String juan, String number, String direcciónX) {
    }


    public void agregarAliado(Vendedor vendedor) {
        if (aliados.size() < 10) {
            aliados.add(vendedor);
            vendedor.getAliados().add(aliados.add(vendedor));
        }
    }


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
    public List<Object> setProductosAgregados(List<Producto> productosAgregados){
        this.productosAgregados = productosAgregados;

        return List.of();
    }
    <E> List<E> getAliados() {
        return List.of();
    }

    public <E> List<E> getProductos() {
        return List.of();
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
