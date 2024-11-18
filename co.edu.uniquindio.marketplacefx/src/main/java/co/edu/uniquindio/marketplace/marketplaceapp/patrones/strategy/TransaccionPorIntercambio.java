package co.edu.uniquindio.marketplace.marketplaceapp.patrones.strategy;


import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IStrategyTransaccion;

public class TransaccionPorIntercambio implements IStrategyTransaccion {

    @Override
    public boolean transaccionar(Vendedor usuarioVendedor1, Vendedor usuarioVendedor2, Producto producto) {



        return true;
    }
}
