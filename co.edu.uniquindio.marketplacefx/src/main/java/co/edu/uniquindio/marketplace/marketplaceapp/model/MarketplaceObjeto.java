package co.edu.uniquindio.marketplace.marketplaceapp.model;

import co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IMarketplace;
import javafx.scene.image.Image;

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
    public boolean eliminarVendedor(String nombre,
                                 String apellido,
                                 String cedula,
                                 String direccion,
                                 Usuario usuario){
        Vendedor vendedorEncontrado = obtenerVendedor(cedula);
        if(vendedorEncontrado != null){
            Vendedor vendedor = getBuildVendedor(nombre, apellido, cedula, direccion, usuario);
            getListaVendedores().remove(vendedor);
            return true;
        } else {
            return false;
        }
    }
    public boolean eliminarVendedor(Vendedor vendedor) {
        Vendedor vendedorEncontrado = obtenerVendedor(vendedor.getCedula());
        if (vendedorEncontrado != null) {
            getListaVendedores().remove(vendedorEncontrado);
            return true;
        } else {
            return false;
        }
    }
    public boolean actualizarVendedor(Vendedor vendedor){
        Vendedor vendedorEncontrado = obtenerVendedor(vendedor.getCedula());
        if (vendedorEncontrado != null) {
            vendedorEncontrado.setNombre(vendedor.getNombre());
            vendedorEncontrado.setApellido(vendedor.getApellido());
            vendedorEncontrado.setDireccion(vendedor.getDireccion());
            vendedorEncontrado.getUsuario().setUserName(vendedor.getUsuario().getUserName());
            vendedorEncontrado.getUsuario().setPassword(vendedor.getUsuario().getPassword());
            return true;
        } else {
            return false;
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
    public Vendedor obtenerVendedor(String cedula) {
        Vendedor vendedor = null;
        for (Vendedor vendedor1 : getListaVendedores()) {
            if(vendedor1.getCedula().equalsIgnoreCase(cedula)){
                vendedor = vendedor1;
                break;
            }
        }

        return vendedor;
    }
    public boolean crearProducto(Publicacion publicacion,
                                 String nombre,
                                 String identificador,
                                 Image imagen,
                                 String categoria,
                                 int precio,
                                 EstadoProducto estado){
        Producto productoEncontrado = obtenerProducto(identificador);
        if(productoEncontrado == null){
            Producto producto = getBuildProducto(publicacion, nombre, identificador, imagen, categoria, precio, estado);
            obtenerListaProducto().add(producto);
            return true;
        } else {
            return false;
        }
    }
    public boolean crearProducto(Producto nuevoProducto){
        Producto productoEncontrado = obtenerProducto(nuevoProducto.getIdentificador());
        if(productoEncontrado == null){
            obtenerListaProducto().add(nuevoProducto);
            return true;
        } else {
            return false;
        }
    }
    public boolean eliminarProducto(Publicacion publicacion,
                                    String nombre,
                                    String identificador,
                                    Image imagen,
                                    String categoria,
                                    int precio,
                                    EstadoProducto estado){
        Producto productoEncontrado = obtenerProducto(identificador);
        if(productoEncontrado != null){
            Producto producto = getBuildProducto(publicacion, nombre, identificador, imagen, categoria, precio, estado);
            obtenerListaProducto().remove(producto);
            return true;
        } else {
            return false;
        }
    }
    public boolean eliminarProducto(Producto producto){
        Producto productoEncontrado = obtenerProducto(producto.getIdentificador());
        if(productoEncontrado != null){
            obtenerListaProducto().remove(productoEncontrado);
            return true;
        } else {
            return false;
        }
    }
    public boolean actualizarProducto(Producto producto){
        Producto productoEncontrado = obtenerProducto(producto.getIdentificador());
        if(productoEncontrado != null){
            productoEncontrado.setNombre(producto.getNombre());
            productoEncontrado.setIdentificador(producto.getIdentificador());
            productoEncontrado.setImagen(producto.getImagen());
            productoEncontrado.setCategoria(producto.getCategoria());
            productoEncontrado.setEstado(producto.getEstado());
            return true;
        } else {
            return false;
        }
    }
    private Producto getBuildProducto(Publicacion publicacion,
                                      String nombre,
                                      String identificador,
                                      Image imagen,
                                      String categoria,
                                      int precio,
                                      EstadoProducto estado){
        return Producto.builder()
                .publicacion(publicacion)
                .nombre(nombre)
                .identificador(identificador)
                .imagen(imagen)
                .categoria(categoria)
                .precio(precio)
                .build();
    }
    private Producto obtenerProducto(String identificador){
        Producto producto = null;
        for(Producto producto1 : obtenerListaProducto()){
            if(producto1.getIdentificador().equalsIgnoreCase(identificador)){
                producto = producto1;
                break;
            }
        }

        return producto;
    }
    public List<Producto> obtenerListaProducto(){
        List<Producto> productos = new ArrayList<>();
        for(Vendedor vendedor : listaVendedores){
            productos.addAll(vendedor.getProductosAgregados());
        }
        return productos;
    }
    public List<Vendedor> getListaVendedores() {return listaVendedores;}
    public List<Usuario> getListaUsuarios(){return listaUsuarios;}
    public Administrador getAdministrador(){return administrador;}
    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    public void setAdministrador(Administrador administrador){
        this.administrador = administrador;
    }
}