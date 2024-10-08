package co.edu.uniquindio.marketplace.marketplaceapp.model;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceObjeto {
    private List<Vendedor> listaVendedores;
    private List<Usuario> listaUsuarios;
    private Administrador administrador;
    public MarketplaceObjeto(){
        this.listaVendedores = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }
    public boolean crearVendedor(String nombre,
                                String apellido,
                                String cedula,
                                String direccion,
                                Usuario usuario){
        Vendedor vendedorEncontrado = obtenerVendedor(cedula);
        if(vendedorEncontrado == null){
            Vendedor vendedor = getBuildVendedor(nombre, apellido, cedula, direccion, usuario);
            getListaVendedores().add(vendedor);
            return true;
        }else{
            return  false;
        }
    }
    public boolean crearVendedor(Vendedor nuevoVendedor){
        Vendedor vendedorEncontrado = obtenerVendedor(nuevoVendedor.getCedula());
        if(vendedorEncontrado == null){
            getListaVendedores().add(nuevoVendedor);
            return true;
        }else{
            return  false;
        }
    }
    private Vendedor getBuildVendedor(String nombre,
                                      String apellido,
                                      String cedula,
                                      String direccion,
                                      Usuario usuario) {
        return Vendedor.builder()
                .nombre(nombre)
                .apellido(apellido)
                .cedula(cedula)
                .direccion(direccion)
                .usuario(usuario)
                .build();
    }

    private Vendedor obtenerVendedor(String cedula) {
        Vendedor vendedor = null;
        for (Vendedor vendedor1: getListaVendedores()) {
            if(vendedor1.getCedula().equalsIgnoreCase(cedula)){
                vendedor = vendedor1;
                break;
            }
        }

        return vendedor;
    }
    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

}
