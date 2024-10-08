package co.edu.uniquindio.marketplace.marketplaceapp.model;

import java.util.List;
import java.util.ArrayList;


public class Marketplace {
    private Vendedor vendedor;
    private Administrador administrador;
    private Usuario usuario;
    private List<Vendedor> listaVendedores;
    private List<Usuario> listaUsuarios;
    public Marketplace(){
        this.administrador = new Administrador();
        this.listaVendedores = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }
    public Administrador getAdministrador(){return administrador;}
    public List<Vendedor> getListaVendedores(){return listaVendedores;}
    public List<Usuario> getListaUsuarios(){return listaUsuarios;}
    public void setListaVendedores(List<Vendedor> listaVendedores){
        this.listaVendedores = listaVendedores;
    }
    public void setListaUsuarios(List<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }
    public void agregarVendedor(Vendedor vendedor){this.vendedor = vendedor;}
    public void agregarAdministrador(Administrador administrador){this.administrador = administrador;}
    public void agregarUsuario(Usuario usuario){this.usuario = usuario;}
}
