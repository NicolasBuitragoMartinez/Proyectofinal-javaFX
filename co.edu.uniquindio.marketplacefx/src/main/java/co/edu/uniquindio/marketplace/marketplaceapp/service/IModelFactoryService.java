package co.edu.uniquindio.marketplace.marketplaceapp.service;

import co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.*;

import java.util.List;

public interface IModelFactoryService {
    List<VendedorDto> obtenerVendedores();
    List<VendedorDto> obtenerVendedoresAgregados(String cedulaVendedor);
    VendedorDto obtenerVendedores(String cedula);
    boolean agregarVendedor(VendedorDto vendedorDto);
    boolean eliminarVendedor(VendedorDto vendedorDto);
    boolean actualizarVendedor(VendedorDto vendedorDto);

    List<UsuarioDto> obtenerUsuarios();

    List<ProductoDto> obtenerProductos();
    List<ProductoDto> obtenerProductosPorVendedor(String cedulaVendedor);
    List<ProductoDto> obtenerProductosPublicados(String cedulaVendedor);
    boolean agregarProducto(ProductoDto productoDto);
    boolean eliminarProducto(ProductoDto productoDto);
    boolean actualizarProducto(ProductoDto productoDto);

    int obtenerLikesPublicacion(String identificadorProducto);
    List<ComentarioDto> obtenerComentariosPublicacion(String identificadorProducto);
    boolean incrementarLikesPublicacion(String identificadorProducto);

    boolean agregearComentariosPublicacion(String identificadorProducto, ComentarioDto comentarioDto);
}
