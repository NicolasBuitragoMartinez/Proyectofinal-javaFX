package co.edu.uniquindio.marketplace.marketplaceapp.patrones.strategy;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IStrategyTransaccion;

import static co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto.PUBLICADO;
import static co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto.VENDIDO;

public class TransaccionAliadosDirectos implements IStrategyTransaccion {

    public TransaccionAliadosDirectos() {
    }


    public boolean transaccionar(Vendedor vendedor1, Vendedor vendedor2, Producto producto) {

        if (vendedor1.getVendedoresAliados().contains(vendedor2) && producto.getEstado().equals(PUBLICADO)) {

            producto.setEstado(VENDIDO);
            vendedor2.getProductos().remove(producto);
            vendedor1.getProductos().add(producto);

            return true;
        }

        return false;
    }

    @Override
    public void ejecutarTransaccion() {
        System.out.println("Ejecutando transacción con aliados directos.");
    }
}

