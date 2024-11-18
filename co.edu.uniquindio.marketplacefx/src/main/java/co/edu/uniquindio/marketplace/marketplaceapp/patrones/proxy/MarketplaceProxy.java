package co.edu.uniquindio.marketplace.marketplaceapp.patrones.proxy;


import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Usuario;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IMarketplaceService;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IMarketplaceServiceImpl;

public class MarketplaceProxy implements IMarketplaceService {
    private IMarketplaceServiceImpl servicioReal;
    private Usuario autenticacion;

    public MarketplaceProxy(IMarketplaceServiceImpl servicioReal, Usuario autenticacion) {
        this.servicioReal = servicioReal;
        this.autenticacion = autenticacion;
    }

    private boolean estaAutenticado(String usuario, String contrasena) {
        return autenticacion.autenticar(usuario, contrasena);
    }

    public boolean agregarProducto(String usuario, String contrasena, Producto producto) {
        if (estaAutenticado(usuario, contrasena)) {
            return servicioReal.agregarProducto(usuario, producto);
        }
        System.out.println("Acceso denegado. Autenticación fallida.");
        return false;
    }

    public boolean realizarTransaccion(String usuario,
                                       String contrasena,
                                       Producto producto) {
        if (estaAutenticado(usuario, contrasena)) {
            return servicioReal.realizarTransaccion(usuario, contrasena,
                    producto);
        }
        System.out.println("Acceso denegado. Autenticación fallida.");
        return false;
    }

    @Override
    public boolean agregarProducto(String usuario, Producto producto) {
        return false;
    }

}

