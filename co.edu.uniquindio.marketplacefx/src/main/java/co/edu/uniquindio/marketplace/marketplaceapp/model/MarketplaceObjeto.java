package co.edu.uniquindio.marketplace.marketplaceapp.model;

import co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.strategy.TransaccionPorIntercambio;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Vendedor> obtenerListaVendedorAgregado(String cedulaVendedor) {
        return listaVendedores.stream()
                .filter(vendedor -> vendedor.getCedula() != null && vendedor.getCedula().equals(cedulaVendedor))
                .findFirst()
                .map(Vendedor::getVendedoresAliados)
                .orElse(new ArrayList<>());
    }
    public List<Producto> obtenerProductosPorVendedor(String cedulaVendedor) {
        return listaVendedores.stream()
                .filter(vendedor -> vendedor.getCedula().equals(cedulaVendedor))
                .findFirst()
                .map(Vendedor::getProductosAgregados)
                .orElse(List.of());
    }
    public List<Producto> obtenerProductosPorEstado(String cedula, EstadoProducto estado1, EstadoProducto estado2) {
        return obtenerProductosPorVendedor(cedula).stream()
                .filter(producto -> producto.getEstado() == estado1 || producto.getEstado() == estado2)
                .toList();
    }
    public int obtenerLikesPublicacion(String identificadorProducto) {
        return obtenerProductoPorIdentificador(identificadorProducto)
                .map(producto -> {
                    Publicacion publicacion = producto.getPublicacion();
                    return publicacion != null ? publicacion.getLike() : 0;
                })
                .orElse(0);
    }
    public List<Comentario> obtenerComentariosPublicacion(String identificadorProducto) {
        return obtenerProductoPorIdentificador(identificadorProducto)
                .map(producto -> {
                    Publicacion publicacion = producto.getPublicacion();
                    return publicacion != null ? publicacion.getComentarios() : Collections.<Comentario>emptyList();
                })
                .orElse(Collections.emptyList());
    }
    private Optional<Producto> obtenerProductoPorIdentificador(String identificadorProducto) {
        return obtenerListaProducto().stream()
                .filter(producto -> producto.getIdentificador().equals(identificadorProducto))
                .findFirst();
    }
    public boolean incrementarLikesPublicacion(String identificadorProducto) {
        Optional<Publicacion> publicacionOpt = obtenerPublicacionPorIdentificador(identificadorProducto);

        if (publicacionOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();
            publicacion.darMeGusta();
            return true;
        } else {
            return false;
        }
    }
    public Optional<Publicacion> obtenerPublicacionPorIdentificador(String identificador) {
        Optional<Producto> productoOpt = obtenerListaProducto().stream()
                .filter(producto -> producto.getIdentificador() != null && producto.getIdentificador().equals(identificador))
                .findFirst();

        return productoOpt.map(Producto::getPublicacion);
    }
    public boolean agregarComentarioPublicacion(String identificadorPublicacion, Comentario comentario) {
        Optional<Publicacion> publicacionOpt = obtenerPublicacionPorIdentificador(identificadorPublicacion);
        if (publicacionOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();
            publicacion.agregarComentario(comentario);
            return true;
        }
        return false;
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

    public Vendedor getVendedorPorCredenciales(String username, String password) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getUsuario().getUserName().equals(username) &&
                    vendedor.getUsuario().getPassword().equals(password)) {
                return vendedor;
            }
        }
        return null;
    }

    private Map<String, String> credenciales = new HashMap<>();

    public boolean autenticar(String usuario, String contrasena) {
        return credenciales.containsKey(usuario) && credenciales.get(usuario).equals(contrasena);
    }

    public Persona validarUsuario(String username, String contrasena) throws Exception {
        Persona persona = buscarPorCorreo(username);
        if (persona != null) {
            if (persona.getContrasena().equals(contrasena)) {
                return persona;
            }
        }
        throw new Exception("Los datos de acceso son incorrectos");
    }

    private Persona buscarPorCorreo(String username) {

        Persona[] personas = new Persona[0];
        for (Persona persona : personas) {
            if (persona.getUsername().equals(username)) {
                return persona;
            }
        }

        return null;
    }


    public void setIStrategyTransaccion(TransaccionPorIntercambio transaccionPorIntercambio) {
    }
}