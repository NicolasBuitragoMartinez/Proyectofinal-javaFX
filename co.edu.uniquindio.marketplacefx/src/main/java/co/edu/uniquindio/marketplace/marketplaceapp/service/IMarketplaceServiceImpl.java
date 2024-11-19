package co.edu.uniquindio.marketplace.marketplaceapp.service;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.facade.MarketplaceFacade;

public class IMarketplaceServiceImpl implements IMarketplaceService {
    private MarketplaceFacade facade;

    public IMarketplaceServiceImpl(MarketplaceFacade facade) {
        this.facade = facade;
    }

    @Override
    public boolean agregarProducto(String usuario, Producto producto) {
        facade.agregarProducto(usuario, producto);
        return true;
    }

    @Override
    public boolean realizarTransaccion(String usuarioVendedor1,
                                       String usuarioVendedor2,
                                       Producto producto) {
        return facade.realizarTransaccion(usuarioVendedor1, usuarioVendedor2,
                producto);
    }

}
