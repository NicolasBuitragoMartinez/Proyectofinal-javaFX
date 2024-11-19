package co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator;


import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;

public abstract class ProductoDecorator extends Producto {
    protected Producto productoDecorado;

    public ProductoDecorator(Producto productoDecorado) {
        super(productoDecorado.getNombre(), productoDecorado.getCategoria(),
                productoDecorado.getPrecio(), productoDecorado.getEstado(),
                productoDecorado.getIdProducto());
        this.productoDecorado = productoDecorado;
    }

    @Override
    public String getDetalles() {
        return productoDecorado.getDetalles();
    }

    @Override
    public int getPrecio() {
        return productoDecorado.getPrecio();
    }
}