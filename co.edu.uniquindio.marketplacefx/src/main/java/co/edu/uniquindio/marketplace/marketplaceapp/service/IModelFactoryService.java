package co.edu.uniquindio.marketplace.marketplaceapp.service;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;

import java.util.List;

public interface IModelFactoryService {
    List<VendedorDto> obtenerVendedores();
    VendedorDto obtenerVendedores(String cedula);
    boolean agregarVendedor(VendedorDto vendedorDto);
    boolean eliminarVendedor(VendedorDto vendedorDto);
    boolean actualizarVendedor(VendedorDto vendedorDto);

    List<UsuarioDto> obtenerUsuarios();

    List<ProductoDto> obtenerProductos();
    List<ProductoDto> obtenerProductosPorVendedor(String cedulaVendedor);
    boolean agregarProducto(ProductoDto productoDto);
    boolean eliminarProducto(ProductoDto productoDto);
    boolean actualizarProducto(ProductoDto productoDto);
}
