package co.edu.uniquindio.marketplace.marketplaceapp.controller;


import co.edu.uniquindio.marketplace.marketplaceapp.model.Marketplace;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Usuario;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.facade.MarketplaceFacade;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.proxy.MarketplaceProxy;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.strategy.TransaccionAliadosDirectos;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.strategy.TransaccionPorCategoria;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.strategy.TransaccionPorIntercambio;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IMarketplaceServiceImpl;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IStrategyTransaccion;

import java.util.Arrays;
import java.util.List;

public class MarketplaceController {
    private MarketplaceProxy proxy;
    private final MarketplaceObjeto marketplaceObjeto;
    public static MarketplaceController INSTANCIA;


    private MarketplaceController(){
        marketplaceObjeto = new MarketplaceObjeto();
        marketplaceObjeto.setIStrategyTransaccion(new TransaccionPorIntercambio());

    }

    public static MarketplaceController getInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new MarketplaceController();
        }
        return INSTANCIA;
    }



    public MarketplaceController(Marketplace marketplace){
        this.marketplaceObjeto = new MarketplaceObjeto();
        MarketplaceFacade facade = new MarketplaceFacade();
        IMarketplaceServiceImpl servicioReal = new IMarketplaceServiceImpl(facade);
        Usuario autenticacion = new Usuario();
        this.proxy = new MarketplaceProxy( servicioReal,  autenticacion);
        facade.setEstrategiaTransaccion((TransaccionAliadosDirectos) new TransaccionAliadosDirectos());

    }



    private MarketplaceFacade facade = new MarketplaceFacade();

    public void registrarVendedorDesdeGUI(String nombre, String apellido, String cedula,
                                          String direccion, String usuario, String contrasena) {
        facade.registrarVendedor(nombre, apellido, cedula, direccion, usuario, contrasena);

    }


    public boolean autenticar(String usuario, String contrasena) {
        return facade.autenticar(usuario, contrasena);
    }


    public void cambiarEstrategia(String tipoEstrategia) {
        switch (tipoEstrategia) {
            case "Directa":
                facade.setEstrategiaTransaccion(new TransaccionAliadosDirectos());
                break;

            case "Por Categoría":
                List<String> categorias = Arrays.asList("Electrónica", "Juguetes");
                facade.setEstrategiaTransaccion(new TransaccionPorCategoria(categorias));
                break;

            default:
                throw new IllegalArgumentException("Tipo de estrategia no válida: " + tipoEstrategia);
        }
    }


    public boolean realizarTransaccion(String usuarioVendedor1,
                                               String usuarioVendedor2,
                                               Producto producto) {

        return facade.realizarTransaccion(usuarioVendedor1, usuarioVendedor2,
                producto);
    }

    public boolean agregarProducto(String usuario, Producto producto) {
        return proxy.agregarProducto(usuario,  producto);
    }

}
