package co.edu.uniquindio.marketplace.marketplaceapp.service;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;

public interface IMarketplaceService {

    boolean agregarProducto(String usuario, Producto producto);
    boolean realizarTransaccion(String usuarioVendedor, String usuarioComprador, Producto producto);
}

