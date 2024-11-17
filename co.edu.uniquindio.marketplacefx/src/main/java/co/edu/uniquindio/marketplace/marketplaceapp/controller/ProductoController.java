package co.edu.uniquindio.marketplace.marketplaceapp.controller;

import co.edu.uniquindio.marketplace.marketplaceapp.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.ProductoDto;

import java.util.List;

public class ProductoController {
    ModelFactory modelFactory;
    public ProductoController(){modelFactory = ModelFactory.getInstancia();}
    public List<ProductoDto> obtenerProductos(){return modelFactory.obtenerProductos();}
    public List<ProductoDto> obtenerProductosPorVendedor(String cedulaVendedor) {return modelFactory.obtenerProductosPorVendedor(cedulaVendedor);}
    public boolean agregarProducto(ProductoDto productoDto){return modelFactory.agregarProducto(productoDto);}
    public boolean eliminarProducto(ProductoDto productoDto){return modelFactory.eliminarProducto(productoDto);}
    public boolean actualizarProducto(ProductoDto productoDto){return modelFactory.actualizarProducto(productoDto);}

}