package co.edu.uniquindio.marketplace.marketplaceapp.service;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;

public interface IStrategyTransaccion {
    boolean transaccionar(Vendedor usuarioVendedor1, Vendedor usuarioVendedor2,
                          Producto producto);
}







