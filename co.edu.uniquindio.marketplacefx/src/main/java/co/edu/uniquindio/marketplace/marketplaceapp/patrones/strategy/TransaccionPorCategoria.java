package co.edu.uniquindio.marketplace.marketplaceapp.patrones.strategy;


import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IStrategyTransaccion;

import java.util.List;

import static co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto.PUBLICADO;
import static co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto.VENDIDO;


public class TransaccionPorCategoria implements IStrategyTransaccion {

    private List<String> categoriasPermitidas;


    public TransaccionPorCategoria(List<String> categoriasPermitidas) {
        this.categoriasPermitidas = categoriasPermitidas;
    }

    @Override
    public void ejecutarTransaccion() {
        System.out.println("Ejecutando transacción por categorías: " + String.join(", ", categoriasPermitidas));


    }

    @Override
    public boolean transaccionar(Vendedor vendedor1, Vendedor vendedor2, Producto producto) {

        if (producto.getCategoria().equals(categoriasPermitidas) && producto.getEstado().equals(PUBLICADO)) {
            producto.setEstado(VENDIDO);
            vendedor2.getProductos().remove(producto);
            vendedor1.getProductos().add(producto);
            return true;
        }

        return false;
    }
}


