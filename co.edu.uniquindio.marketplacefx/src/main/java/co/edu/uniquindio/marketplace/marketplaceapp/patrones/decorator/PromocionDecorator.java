package co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;

public class PromocionDecorator extends ProductoDecorator {
    private double descuento;

    public PromocionDecorator(Producto productoDecorado) {
        super(productoDecorado);
        this.descuento = descuento;
    }

    @Override
    public int getPrecio() {
        return (int) (productoDecorado.getPrecio() - (productoDecorado.getPrecio() * descuento));
    }

    @Override
    public String getDetalles() {
        return productoDecorado.getDetalles() + " | Promoción: -" + (descuento * 100) + "%";
    }
}
