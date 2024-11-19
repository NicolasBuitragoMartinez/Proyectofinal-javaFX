package co.edu.uniquindio.marketplace.marketplaceapp.service;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplaceapp.model.*;

import java.util.List;

public interface IMarketplaceMapping {
    List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores);
    VendedorDto vendedorToVendedorDto(Vendedor vendedor);
    Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);
    List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios);
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
    List<ProductoDto> getProductosDto(List<Producto> listaProductos);
    ProductoDto productoToProductoDto(Producto producto);
    Producto productoDtoToProducto(ProductoDto productoDto);
    List<PublicacionDto> getPublicacionesDto(List<Publicacion> listaPublicaciones);
    PublicacionDto publicacionToPublicacionDto(Publicacion publicacion);
    Publicacion publicacionDtoToPublicacion(PublicacionDto publicacionDto);
    List<ComentarioDto> getComentariosDto(List<Comentario> listaComentarios);
    ComentarioDto comentarioToComentarioDto(Comentario comentario);
    Comentario comentarioDtoToComentario(ComentarioDto comentarioDto);

}
