package co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;

public class GarantiaExtendidaDecorator extends ProductoDecorator {
    private int mesesGarantia;

    public GarantiaExtendidaDecorator(Producto productoDecorado) {
        super(productoDecorado);
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public String getDetalles() {
        return productoDecorado.getDetalles() + " | Garantía extendida: " + mesesGarantia + " meses";
    }
}
