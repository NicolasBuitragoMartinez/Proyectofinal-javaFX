package co.edu.uniquindio.marketplace.marketplaceapp.model;

import java.util.List;
import java.util.ArrayList;


public class Marketplace {
    private static Marketplace instancia;
    private Vendedor vendedor;
    private Administrador administrador;
    private Usuario usuario;
    private List<Vendedor> listaVendedor;
    private List<Usuario> listaUsuario;
    private Marketplace(){
        this.administrador = new Administrador();
        this.listaVendedor = new ArrayList<>();
        this.listaUsuario = new ArrayList<>();
    }
    public static Marketplace getInstancia() {
        if (instancia == null) {instancia = new Marketplace();}
        return instancia;
    }
    public Administrador getAdministrador(){return administrador;}
    public List<Vendedor> getListaVendedor(){return listaVendedor;}
    public List<Usuario> getListaUsuario(){return listaUsuario;}
    public void setListaVendedor(List<Vendedor> listaVendedor){
        this.listaVendedor = listaVendedor;
    }
    public void setListaUsuario(List<Usuario> listaUsuario){
        this.listaUsuario = listaUsuario;
    }
    public void agregarVendedor(Vendedor vendedor){this.vendedor = vendedor;}
    public void agregarAdministrador(Administrador administrador){this.administrador = administrador;}
    public void agregarUsuario(Usuario usuario){this.usuario = usuario;}
}
